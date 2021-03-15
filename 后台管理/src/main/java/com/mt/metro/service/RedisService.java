package com.mt.metro.service;


import com.mt.metro.entity.Statistic;
import com.mt.metro.entity.User;
import com.mt.metro.utils.RedisKeyUtils;
import com.mt.metro.utils.Time;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RedisService {

    @Resource
    RedisTemplate redisTemplate;


    // 统计当日访问
    public void setLoginNumber(User user){
        redisTemplate.opsForValue().increment(RedisKeyUtils.MAP_KEY_TOTAL_LOGIN,1);
        // 利用redis的hash包含键值对的无序散列表，这样都在一个键里
        redisTemplate.opsForHash().increment(RedisKeyUtils.MAP_KEY_USER_CITY_LOGIN,user.getCity(),1);


    }



    public List<Statistic> getCityLoginFromRedis() {
        int totalNumber = (int)redisTemplate.opsForValue().get(RedisKeyUtils.MAP_KEY_TOTAL_LOGIN);
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan(RedisKeyUtils.MAP_KEY_USER_CITY_LOGIN, ScanOptions.NONE);
        List<Statistic> list = new ArrayList<>();
        while (cursor.hasNext()){
            Map.Entry<Object, Object> entry = cursor.next();
            String key = (String) entry.getKey();
            //分离出 likedUserId，likedPostId
            // String[] split = key.split("::");
            // String likedUserId = split[0];
            // String likedPostId = split[1];
            Integer value = (Integer) entry.getValue();


            //组装Statistic 对象
            Statistic statistic = new Statistic();
            statistic.setCity(key);
            statistic.setCitynum(value);
            statistic.setTotalnum(totalNumber);
            statistic.setStatime(Time.getDateCurrentTime());

            System.out.println(Time.getDateCurrentTime());
            list.add(statistic);
            //存到 list 后从 Redis 中删除
            redisTemplate.opsForHash().delete(RedisKeyUtils.MAP_KEY_USER_CITY_LOGIN, key);
        }
        redisTemplate.opsForValue().set(RedisKeyUtils.MAP_KEY_TOTAL_LOGIN,0);
        return list;
    }




}
