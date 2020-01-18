package com.mt.metro.service;

import com.mt.metro.entity.Parameter;
import com.mt.metro.mapper.ParameterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Autowired
    ParameterMapper parameterMapper;

    public Parameter getParam(){
        Parameter parameter = (Parameter) redisTemplate.opsForValue().get("parameter");
        System.out.println(parameter);
        if(parameter !=null){
            return parameter;
        }else {
            parameter = queryParam();
            return parameter;
        }

    }

    @Scheduled(cron = "0 0 0 * * *")
    public Parameter queryParam(){
        Parameter parameter = parameterMapper.selectByPrimaryKey(1);
        redisTemplate.opsForValue().set("parameter",parameter);
        return parameter;
    }
}
