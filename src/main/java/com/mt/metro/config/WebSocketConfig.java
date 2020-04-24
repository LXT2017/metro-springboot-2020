package com.mt.metro.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 开启websocket
 * @author Shawn
 */
@Configuration
public class WebSocketConfig {


    /**
     *  TODEO如果用外置tomcat，要注释掉以下代码，否则启动项目会报错，用springboot内置tomcat就得放开以下代码
     */
    //@Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
