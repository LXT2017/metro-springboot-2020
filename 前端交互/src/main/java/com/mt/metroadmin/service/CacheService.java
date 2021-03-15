package com.mt.metroadmin.service;


import com.mt.metroadmin.entity.Achievement;
import com.mt.metroadmin.mapper.AchievementMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {



    @Autowired
    AchievementMapper achievementMapper;

    private final Logger logger = LogManager.getLogger(CacheService.class);

    /**
     * 成就称号缓存
     */
    @Cacheable(value = "achieve",key = "#id")
    public Achievement getAchievement(int id){
        logger.info("getAchievement+缓存");
        return achievementMapper.selectById(id);
    }
}
