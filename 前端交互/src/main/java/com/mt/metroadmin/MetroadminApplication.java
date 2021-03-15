package com.mt.metroadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.mt.metroadmin.mapper")
@EnableCaching
public class MetroadminApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MetroadminApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MetroadminApplication.class);
    }
}
