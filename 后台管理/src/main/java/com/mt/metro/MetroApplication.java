package com.mt.metro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableRabbit
@EnableScheduling
@MapperScan("com.mt.metro.mapper")
@EnableCaching
public class MetroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetroApplication.class, args);
    }

}
