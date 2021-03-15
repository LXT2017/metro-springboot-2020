package com.mt.metro.service;


import com.alibaba.fastjson.JSONObject;
import com.mt.metro.entity.User;
import com.mt.metro.mapper.UserMapper;
import com.mt.metro.websocket.WebSocketServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class RabbitMqService {

    @Autowired
    RedisService redisService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    WebSocketServer webSocketServer;

    private final Logger logger = LogManager.getLogger(AsyncService.class);

    /**
     * 监听login队列
     * 跟新数据到数据库
     * @param map
     */
    @Transactional(rollbackFor = Exception.class)
    @RabbitListener(queues = "login")
    public void receive(Map map){
        System.out.println("Rabbit" + map);
        String ip = (String) map.get("ip");
        User user = new User();
        user.setId((int)map.get("id"));

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000); //haomiao
        requestFactory.setReadTimeout(5000); //haomiao
        RestTemplate restTemplate=new RestTemplate(requestFactory);
        Map<String,String> params=new HashMap<>();
        params.put("ip",ip);
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
        redisService.setLoginNumber(user);
        userMapper.updateByPrimaryKeySelective(user);

    }


    /**
     * 监听队列strength
     * 进行消息推送
     */
    @RabbitListener(queues = "strength")
    public void msgSend(Map map) throws IOException {
        System.out.println(map);
        String id = (String)map.get("id");
        map.remove("id");
        WebSocketServer.sendInfo(JSONObject.toJSONString(map),id);
        //webSocketServer.sendMessage(map);
    }

}
