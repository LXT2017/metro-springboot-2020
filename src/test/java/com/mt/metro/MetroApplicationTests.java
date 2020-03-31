package com.mt.metro;

import com.mt.metro.common.Schedule;
import com.mt.metro.mapper.AchievementMapper;
import com.mt.metro.mapper.CarbonRankingMapper;
import com.mt.metro.service.MallService;
import com.mt.metro.service.NewsService;
import com.mt.metro.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class MetroApplicationTests {

    @Autowired
    MallService mallService;

    @Autowired
    UserService userService;

    @Autowired
    NewsService newsService;

    @Autowired
    CarbonRankingMapper carbonRankingMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    Schedule schedule;


    @Autowired
    AchievementMapper achievementMapper;


    @Test
    void contextLoad() {
        int number = achievementMapper.countByExample(null);
        System.out.println(number);
    }


    //@Test
    void getInitialTest() {
        //System.out.println(userService.getInitialInfo(null));
        //System.out.println(userService.getCarbonRanking(1));
        System.out.println(mallService.getMallInfo(1));
    }



}
