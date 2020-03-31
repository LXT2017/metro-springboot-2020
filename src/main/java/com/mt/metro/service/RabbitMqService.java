package com.mt.metro.service;


import com.mt.metro.entity.User;
import com.mt.metro.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class RabbitMqService {

    @Autowired
    UserMapper userMapper;

    private final Logger logger = LogManager.getLogger(AsyncService.class);

    @RabbitListener(queues = "login")
    public void receive(Map map){
        System.out.println("Rabbit" + map);
        String ip = (String) map.get("ip");
        User user = new User();
        user.setId((int)map.get("id"));


        RestTemplate restTemplate=new RestTemplate();
        Map<String,String> params=new HashMap<>();
        params.put("ip",ip);  //
        ResponseEntity<String> responseEntity=restTemplate.getForEntity("http://ip.ws.126.net/ipquery?ip={ip}",String.class,params);

        // 字符串解析
        String resultStr = responseEntity.getBody().trim();
        int provinceNum = resultStr.indexOf("lo") +4 ;
        int cityNum = resultStr.indexOf("lc")  +4;
        String province = resultStr.trim().substring(provinceNum,provinceNum+3);
        String city = resultStr.trim().substring(cityNum,cityNum+3);

        if(city == null || province == null){
            logger.error("IP获取城市信息错误");
            throw  new RuntimeException("IP获取城市信息错误");
        }

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 保存到数据库的数据
        String citySql = province + city;
        user.setCity(citySql);
        userMapper.updateByPrimaryKeySelective(user);

    }



}
