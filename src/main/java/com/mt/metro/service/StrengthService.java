package com.mt.metro.service;

import com.mt.metro.utils.RedisKeyUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn
 * 体力值根据用户上线和离线时间差
 */
@Service
public class StrengthService {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    private Logger logger = LogManager.getLogger(this.getClass());
    /**
     * 体力值流失
     * 多少时间一点体力值，秒
     */
    final int LOSS = 60;
    /**
     * 毫秒，体力最长流失时间
     */
    final int LOSSTIME = LOSS*100*1000;
    /**
     *每次游戏增加的体力值
     */
    final int ADDSTRENGTH = 10;

    /**
     * 查询当前体力值
     * @return
     */
    public int getCurrentStrength(String id){
        int strength = (int)redisTemplate.opsForHash().get(RedisKeyUtils.STRENGTH,id);
        int lossStrength =((int)(System.currentTimeMillis()-(long)redisTemplate.opsForHash().get(RedisKeyUtils.LOGIN_TIME,id))) / 1000/LOSS;
        if(lossStrength<=strength){
            strength = strength - lossStrength;
        }else {
            strength = 0;
        }
        logger.info("读取当前体力值"+strength);
        return strength;
    }


    /**
     * 获取登录时体力值，刷新
     */
    public int getLoginStrength(String id){
        int strength = getCurrentStrength(id);

        redisTemplate.opsForHash().put(RedisKeyUtils.STRENGTH,id,strength);
        redisTemplate.opsForHash().put(RedisKeyUtils.LOGIN_TIME, id,System.currentTimeMillis());
        logger.info("获取登录体力"+strength);
        return strength;
    }

    /**
     * 增加体力值
     */
    public void addStrength(String id){
        int strength = getCurrentStrength(id);
        if(strength+ADDSTRENGTH<=100){
            strength=strength+ADDSTRENGTH;
        }else {
            strength=100;
        }
        redisTemplate.opsForHash().put(RedisKeyUtils.LOGIN_TIME,id,System.currentTimeMillis());
        redisTemplate.opsForHash().put(RedisKeyUtils.STRENGTH,id,strength);
        logger.info("增加体力值" + strength);
    }


    /**
     * 监听器模式
     * 监听登录，就推送体力值状态
     */
    public void msgSend(String id) throws InterruptedException {

        Thread.sleep(1000*20);
        int strength = getCurrentStrength(id);
        // 100是健康状态
        int code = 100;
        String msg,status;
        if(strength<20){
            status = "不健康";
            msg = "体力值已小于20，请赶快运动起来！";
        }else if(strength>80){
            status="健康";
            msg = "体力值大于80,请继续保持哦";
        }else {
            status="亚健康";
            msg="处于亚健康呢，可以锻炼了";
        }

        //放入消息队列，防止大量请求导致接口瘫痪
        Map map = new HashMap(16);
        map.put("id",id);
        map.put("code",code);
        map.put("status",status);
        map.put("msg",msg);
        rabbitTemplate.convertAndSend("exchange.direct","strength",map);


    }
}
