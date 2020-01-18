package com.mt.metro.controller;

import com.mt.metro.annotation.PassToken;
import com.mt.metro.annotation.UserLoginToken;
import com.mt.metro.common.ResponseResult;
import com.mt.metro.common.Time;
import com.mt.metro.entity.User;
import com.mt.metro.service.TokenService;
import com.mt.metro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author jinbin
 * @date 2018-07-08 20:45
 */
@RestController
@RequestMapping("user")
public class UserLogin {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    //登录
    @PassToken
    @PostMapping("/login")
    public ResponseResult login(User user){
        ResponseResult responseResult;
        User userForBase = userService.findUserByUId(user);
        //假设传过来的都是合法用户
        if(userForBase==null){
            System.out.println("用户不存在");
            userForBase = userService.registry(user);
        }

        String token = tokenService.getToken(userForBase);
        Map map = new HashMap();
        map.put("token",token);
        map.put("user",userForBase);

        responseResult = new ResponseResult(100,"success",map);
        return responseResult;

    }


    /**
     * 查询签到
     */
    @UserLoginToken
    @GetMapping("/querySignIn")
    public ResponseResult querySignIn(@RequestParam(value = "id")int id){
        return userService.querySignIn(id);
    }


    /**
     * 签到
     * @return
     */
    @UserLoginToken
    @PostMapping("/signIn")
    public ResponseResult signIn(@RequestParam(value = "id")int id){
        return userService.signIn(id);
    }



    @UserLoginToken
    @PostMapping("/infoModify")
    public ResponseResult infoModify(User user){
        int i = userService.infoModify(user);
        if(i == 0){
            return new ResponseResult(501,"更新失败",null);
        }else {
            return new ResponseResult(100,"更新成功",null);
        }

    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        System.out.println(Time.getRefreshTime());
        return "你已通过验证";
    }
}
