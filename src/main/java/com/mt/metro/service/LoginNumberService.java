package com.mt.metro.service;

import com.mt.metro.entity.Statistic;
import com.mt.metro.mapper.StatisticMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoginNumberService {

    @Autowired
    StatisticMapper statisticMapper;

    @Autowired
    RedisService redisService;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Transactional
    public void transLoginNumber(){
        List<Statistic> list = redisService.getCityLoginFromRedis();
        for (Statistic it:list){
            statisticMapper.insertSelective(it);
        }
        logger.info("每日数据登录数据库插入成功");
    }
}
