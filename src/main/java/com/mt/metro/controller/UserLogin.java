package com.mt.metro.controller;

import com.mt.metro.annotation.PassToken;
import com.mt.metro.annotation.UserLoginToken;
import com.mt.metro.annotation.VisitLog;
import com.mt.metro.common.ResponseResult;
import com.mt.metro.common.Time;
import com.mt.metro.entity.Feedback;
import com.mt.metro.entity.User;
import com.mt.metro.service.TokenService;
import com.mt.metro.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author jinbin
 * @date 2018-07-08 20:45
 */
@RestController
@RequestMapping("user")
public class UserLogin {
    //我也不知道为什么要用set注入，另一个文件field注入不警告
    final
    private UserService userService;
    final
    private TokenService tokenService;

    public UserLogin(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }


    /**
     * 用户初始化以及公共资源获取
     * @param user
     * @return
     */
    @PassToken
    @PostMapping("/login")
    public ResponseResult login(User user){
        ResponseResult responseResult;
        User userForBase = (User)userService.findUserByUId(user);
        //假设传过来的都是合法用户
        if(userForBase==null) {
            System.out.println("用户不存在");
            userForBase = userService.registry(user);
        }
        Map map = userService.getInitialInfo(userForBase);
        String token = tokenService.getToken(userForBase);
        map.put("token",token);

        responseResult = new ResponseResult(200,"success",map);
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
     * @return 信息
     */
    @UserLoginToken
    @PostMapping("/signIn")
    public ResponseResult signIn(@RequestParam(value = "id")int id){
        return userService.signIn(id);
    }



    @VisitLog
    @UserLoginToken
    @PostMapping("/infoModify")
    @SuppressWarnings("unchecked")//取消分析
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





    //查询用户碳积分情况，需要用户id
    @GetMapping("/getCarbonRanking")
    public ResponseResult getCarbonRanking(int option){
        if(option != 1 && option != 2){
            return new ResponseResult(400,"参数错误",null);
        }
        Map map = (Map)userService.getCarbonRanking(option);
        ResponseResult result = new ResponseResult(200,"success",map);
        return result;
    }


    /**
     * 反馈模块
     */
    @PostMapping("/feedBack")
    public ResponseResult postFeedBack(Feedback feedback) {
        int code = 400;
        String msg = "fail";
        if (userService.postFeedBack(feedback)) {
            code = 200;
            msg = "success";
        }
        return new ResponseResult(code, msg, null);
    }
}
