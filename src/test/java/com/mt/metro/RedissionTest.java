package com.mt.metro;

import com.mt.metro.redis.DistributedRedisLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedissionTest {

    @Resource
    DistributedRedisLock distributedRedisLock;

    @Resource
    private RedissonClient redissonClient;

    //@Test
    public void RedissionTest(){
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Boolean lockFlag = distributedRedisLock.lock("LOCK");
                    System.out.println("以获取");
                }
            }).start();
        }

    }


}
