package com.mt.metro;

import com.mt.metro.service.LoginNumberService;
import com.mt.metro.service.RedisService;
import com.mt.metro.utils.RedisKeyUtils;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest
public class RabbitMQTest {


    @Autowired
    RabbitTemplate rabbitTemplate;


    @Autowired
    RedisService redisService;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    LoginNumberService loginNumberService;

    @Autowired
    RedisTemplate redisTemplate;

    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("name"));
        amqpAdmin.declareQueue(new Queue("name.queue",true));
        amqpAdmin.declareBinding(new Binding("name.queue", Binding.DestinationType.QUEUE,"name","amqp.haha",null));

    }

    //@Test
    public void contextLoads() {
        //message自己构造
       //rabbitTemplate.send(exchage,routeKey,message);
        //默认消息体
        //rabbitTemplate.convertAndSend(object);
        //对象被默认序列化
        Map map = new HashMap();
        map.put("msg","helloword");
        map.put("data", Arrays.asList("jkdsnj",123,true));
       rabbitTemplate.convertAndSend("exchange.direct","atguigu",map);
    }


    //@Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu");
        System.out.println(o);
    }

    //将数据转为json发送

   //@Test
    public void getCityLoginFromRedis(){
        //redisService.getCityLoginFromRedis();
        loginNumberService.transLoginNumber();
    }


    //@Test
    public void getCity(){
        redisTemplate.opsForHash().put(RedisKeyUtils.STRENGTH,"1",100);
    }
}
