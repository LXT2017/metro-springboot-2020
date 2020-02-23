package com.mt.metro.controller;

import com.mt.metro.common.ResponseResult;
import com.mt.metro.service.AchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("achieve")
public class AchieveController {

    @Autowired
    AchieveService achieveService;


    /**
     * 成就查询
     * @param userId
     * @param option
     * @return
     */
    @GetMapping("/getAchievementInfo")
    public ResponseResult getAchievement(int userId, int option){
        return achieveService.getAchievement(userId,option);
    }


    /**
     * 查询当前在线时长
     * 查询有几个成就了
     */
    @GetMapping("/getAchievementCount")
    public ResponseResult getAchievementCount(int userId){
        return achieveService.getAchievementCount(userId);
    }
}
