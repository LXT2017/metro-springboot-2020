package com.mt.metro.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mt.metro.entity.Audience;
import com.mt.metro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
    @Autowired
    Audience audience;
    @Resource
    RedisTemplate redisTemplate;

    public String getToken(User user) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String token = "";
        token = JWT.create().withAudience(user.getId().toString())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(audience.getBase64Secret()));// 以 password 作为 token 的密钥

        operations.set(user.getId().toString(), token, 4,TimeUnit.HOURS);
        return token;
    }


}
