package com.mt.metro.controller;

import com.mt.metro.redis.DistributedRedisLock;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lock")
public class LockTestController {

    @Autowired
    private DistributedRedisLock distributedRedisLock;

    // 测试分布式锁
    @GetMapping("/testLock")
    public void testLock() {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    Boolean lockFlag = distributedRedisLock.lock("LOCK");
                    Thread.sleep(100);
                    distributedRedisLock.unlock("LOCK");
                }
            }).start();
        }
    }

}