package com.mt.metro.service;

import com.mt.metro.entity.Parameter;
import com.mt.metro.entity.Sign;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ResourceService {

    @Resource
    RedisTemplate redisTemplate;


    public Parameter getParam() {
        Parameter parameter = (Parameter) redisTemplate.opsForValue().get("parameter");

        if(parameter == null){
            throw new NullPointerException();
        }
        return parameter;
    }




    public Sign getquerySign() {
        Sign sign = (Sign)redisTemplate.opsForValue().get("sign");
        System.out.println(sign);
        if(sign == null){
            throw new NullPointerException();
        }else {
            return sign;
        }
    }



}
