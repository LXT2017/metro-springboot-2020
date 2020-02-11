package com.mt.metro.service;


import com.mt.metro.annotation.Master;
import com.mt.metro.common.Time;
import com.mt.metro.entity.Feedback;
import com.mt.metro.entity.Notice;
import com.mt.metro.mapper.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class NewsService {

    @Autowired
    FeedbackMapper feedbackMapper;

    @Resource
    RedisTemplate redisTemplate;


    //@Master
    public Boolean postFeedBack(Feedback feedback){

        feedback.setfDate(Time.getDateCurrentTime());
        int i = feedbackMapper.insertSelective(feedback);
        if(i == 1){
            return true;
        }else {
            return false;
        }
    }







    @Master
    public Boolean postNotice(Notice notice){
        ValueOperations<String, Notice> operations = redisTemplate.opsForValue();
        String key = Time.getCurrentDate();
        operations.set("notice",notice,200, TimeUnit.SECONDS);
        return true;
    }
}
