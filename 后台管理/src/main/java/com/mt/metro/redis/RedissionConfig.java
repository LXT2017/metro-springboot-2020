package com.mt.metro.redis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * redission配置
 * @author Shawn
 */
@Configuration
public class RedissionConfig {

    @Autowired
    private RedisProperties redisProperties;

    private final Logger log = LogManager.getLogger(this.getClass());

    @Bean
    public RedissonClient redissonClient() {
        RedissonClient redissonClient;

        Config config = new Config();
        String url = "redis://" + redisProperties.getHost() + ":" + redisProperties.getPort();
        System.out.println(url);
        System.out.println(redisProperties.getPassword());
        config.useSingleServer().setAddress(url)
                .setPassword(redisProperties.getPassword()==""?null:redisProperties.getPassword())
                .setDatabase(redisProperties.getDatabase());

        try {
            redissonClient = Redisson.create(config);
            return redissonClient;
        } catch (Exception e) {
            log.error("RemissionClient init redis url:[{}], Exception:", url, e);
            return null;
        }
    }

    //@Bean
    public RedissonClient getRedission(){
        Config config = new Config();
        //单机模式  依次设置redis地址和密码
        config.useSingleServer().
                setAddress("redis://127.0.0.1:6379");

        System.out.println("????");
        return Redisson.create(config);
    }


}
