package com.mt.metroadmin.controller;

import com.mt.metroadmin.annotation.PassToken;
import com.mt.metroadmin.annotation.UserLoginToken;
import com.mt.metroadmin.common.ResponseResult;
import com.mt.metroadmin.entity.Admin;
import com.mt.metroadmin.service.AdminService;
import com.mt.metroadmin.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author jinbin
 * @date 2018-07-08 20:45
 */
//@Api(description = "管理员登录接口，返回的token后续所有接口的请求头都需带上")
@RestController
@RequestMapping("login")
@Api(tags = "管理员登录接口")
public class AdminLogin {
    @Autowired
    AdminService adminService;
    @Autowired
    TokenService tokenService;

    //登录
    @ApiOperation(value = "管理员登录接口",
            notes="登录是关键，后续所有操作必须登录后才行，而每个账户的权限也不同，而登录过期时间默认2小时", produces="application/json" )
    @PassToken
    @PostMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",required = true,value = "用户名"),
            @ApiImplicitParam(name = "password",required = true,value = "密码")
    })
    public ResponseResult login(String userName,String password) {
        Admin admin = new Admin();
        admin.setPassword(password);
        admin.setUserName(userName);
        // return adminService.findByUsername(admin);
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        System.out.println(admin);
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(admin.getUserName(),admin.getPassword());
        // 执行认证登陆
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return new ResponseResult(400,"未知账户",null);
        } catch (IncorrectCredentialsException ice) {
            return new ResponseResult(400,"密码不正确",null);
        } catch (LockedAccountException lae) {
            return new ResponseResult(400,"账户已锁定",null);
        } catch (ExcessiveAttemptsException eae) {
            return new ResponseResult(400,"用户名或密码错误次数过多",null);
        } catch (AuthenticationException ae) {
            return new ResponseResult(400,"用户名或密码不正确！",null);
        }
        if (subject.isAuthenticated()) {
            HashMap map = new HashMap();
            map.put("token",tokenService.getToken(admin));
            return new ResponseResult(200,"登录成功",map);
        }

        token.clear();
        return new ResponseResult(200,"登录失败",null);

    }


    @ApiOperation(value = "token测试",
            notes="你可以带上token来进行测试，成功就可以返回消息", produces="application/json" )
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "测试，你已通过验证";
    }


    @ApiOperation(value = "权限测试",notes = "只有root权限才能访问该接口")
    @RequiresRoles("root")
    @GetMapping("/show")
    public String showUser() {
        return "这是测试";
    }

}
