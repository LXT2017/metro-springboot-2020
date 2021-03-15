package com.mt.metro.controller;


import com.mt.metro.service.StrengthService;
import com.mt.metro.utils.RedisKeyUtils;
import com.mt.metro.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn
 */
@RestController
@RequestMapping("/strength")
public class StrengthController {

    @Autowired
    StrengthService strengthService;

    @Resource
    RedisTemplate redisTemplate;

    /**
     * 获取最新体力值
     * @param id
     * @return
     */
    @GetMapping("/getCurrentStrength")
    public ResponseResult getCurrentStrength(int id){
        Map map = new HashMap(16);
        map.put("currentStrength",strengthService.getCurrentStrength(String.valueOf(id)));
        return new ResponseResult(200,"suceess",map);
    }


    /**
     * 增加体力值
     * 这里测试
     */
    @GetMapping("/addStrength")
    public int addStrength(int id){
        strengthService.addStrength(String.valueOf(id));
        return strengthService.getCurrentStrength(String.valueOf(id));
    }

    /**
     * 这里测试
     */
    @GetMapping("/test")
    public String test(int id){
        redisTemplate.opsForHash().put(RedisKeyUtils.STRENGTH, String.valueOf(id),100);
        redisTemplate.opsForHash().put(RedisKeyUtils.LOGIN_TIME,String.valueOf(1),System.currentTimeMillis());
        return "成功";
    }

}
