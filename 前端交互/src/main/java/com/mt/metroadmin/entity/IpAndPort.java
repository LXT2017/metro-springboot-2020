package com.mt.metroadmin.entity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Shawn
 */
@Component
@ConfigurationProperties(prefix = "ipport")
@Data
public class IpAndPort {

    private String name;

    private String ip;

    private String port;

}
