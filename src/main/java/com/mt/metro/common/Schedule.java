package com.mt.metro.common;

import com.mt.metro.entity.Parameter;
import com.mt.metro.entity.Sign;
import com.mt.metro.mapper.ParameterMapper;
import com.mt.metro.mapper.SignMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Schedule {

    @Resource
    RedisTemplate redisTemplate;

    @Autowired
    ParameterMapper parameterMapper;


    @Autowired
    SignMapper signMapper;


    private final Logger logger = LogManager.getLogger(this.getClass());

    // 定时任务类只能void类型
    @Scheduled(cron = "0 0 0 * * ?")
    public void queryParam() {
        Parameter parameter = parameterMapper.selectByPrimaryKey(1);
        redisTemplate.opsForValue().set("parameter", parameter);
        logger.info("游戏参数" + System.currentTimeMillis());
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void querySign() {
        Sign sign = signMapper.selectByPrimaryKey(1);
        redisTemplate.opsForValue().set("sign", sign);
        logger.info("签到信息" + System.currentTimeMillis());
    }



    @Scheduled(cron = "0 0 0 * * ?")
    public void getWeek(){
        if(Time.getWeek() == 1){
            redisTemplate.opsForValue().set("flag",true);
        }else {
            redisTemplate.opsForValue().set("flag",false);
        }
        logger.info("写入参数getweek");
    }
}
