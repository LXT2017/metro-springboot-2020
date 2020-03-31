package com.mt.metro.common;

import com.mt.metro.entity.Parameter;
import com.mt.metro.entity.Sign;
import com.mt.metro.mapper.*;
import com.mt.metro.service.AchieveService;
import com.mt.metro.utils.Time;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class Schedule {

    @Resource
    RedisTemplate redisTemplate;

    @Autowired
    ParameterMapper parameterMapper;

    @Autowired
    CarbonRankingMapper carbonRankingMapper;

    @Autowired
    CoinMapper coinMapper;

    @Autowired
    SignMapper signMapper;

    @Autowired
    AchieveService achieveService;

    @Autowired
    AchievementMapper achievementMapper;

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
        redisTemplate.opsForValue().set("sign", sign,Time.getRefreshTime(), TimeUnit.SECONDS);
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


    // 金币和积分周排行清零
    @Scheduled(cron = "0 0 0 ? * MON")
    public void setInitialCoinAndCarbon() {
        carbonRankingMapper.updateAllWeekRanking();
        coinMapper.updateAllWeekCoin();
        logger.info("金币和碳积分清零");
    }


    // 积分日排行清零
    @Scheduled(cron = "0 0 0 * * ?")
    public void setDailyCarbon(){

        carbonRankingMapper.updateAllDailyRanking();
        logger.info("碳积分日排行清零");
    }



    // 成就缓存
    //略微有点小问题
    @Scheduled(cron = "0 0 0 * * ?")
    public void setAchievement(){
        int number = achievementMapper.countByExample(null);
        for(int i=1;i<=number;i++){
            achieveService.getAchievement(i);
        }

    }

}
