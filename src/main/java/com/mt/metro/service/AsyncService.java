package com.mt.metro.service;

import com.mt.metro.entity.*;
import com.mt.metro.mapper.*;
import com.mt.metro.utils.IpUtil;
import com.mt.metro.utils.Time;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Shawn
 */
@Service
public class AsyncService {

    @Autowired
    AchievementMapper achievementMapper;
    @Autowired
    AchieveOwnerMapper achieveOwnerMapper;
    @Autowired
    CoinMapper coinMapper;
    @Autowired
    CarbonRankingMapper carbonRankingMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    AchieveService achieveService;

    @Autowired
    StrengthService strengthService;
    @Resource
    RedisTemplate redisTemplate;


    @Autowired
    RabbitTemplate rabbitTemplate;

    private final Logger logger = LogManager.getLogger(AsyncService.class);
     /**
     * 多线程
     * 新用户注册时加载
     * @param
     */
    @Async("taskExecutor")
    public void achievementInitial(User user) {
        List<Achievement> list = achievementMapper.getAll();
        System.out.println(list);


        for (int i = 1;i <= 4; i++) {
            AchieveOwner achieveOwner = new AchieveOwner();
            int j = i;
            List<Achievement> achievementList = list.stream()
                    .filter(s -> s.getCategory().equals(j))
                    .collect(Collectors.toList());
            for (Achievement achievement:achievementList) {
                achieveOwner.setAchievementId(achievement.getId());
                achieveOwner.setUserId(user.getId());
                achieveOwner.setCategory(j);
                achieveOwner.setIsReach(0);
                achieveOwner.setProgress(0);
                achieveOwnerMapper.insertSelective(achieveOwner);
            }
        }
        System.out.println("插入成功");

    }

    /**
     * 所在城市的判断与修改
     * 这里是多线程的执行
     */
    /*@Async
    public void setUserCity(User user,String ip){


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
        System.out.println(user);
        userMapper.updateByPrimaryKey(user);


    }
*/



    /**
     * 用户游戏登录时间的统计
     * 存入redis
     * @param user
     */
    @Async("taskExecutor")
    public void initialResource(User user,HttpServletRequest request){
        // 统计在线时长
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set("online" + user.getId(),System.currentTimeMillis(), Time.getRefreshTime(), TimeUnit.SECONDS);


        String currentIp = IpUtil.getIpAddr(request);
        System.out.println(currentIp);

        // 多线程利用访问ip进行定位，修改地理位置
        // asyncService.setUserCity(user,currentIp);
        //
        //
        // Object o = rabbitTemplate.receiveAndConvert("atguigu");
        // System.out.println(o);

        //放入消息队列，防止大量请求导致接口瘫痪
        Map map = new HashMap(16);
        map.put("ip",currentIp);
        map.put("id",user.getId());
        rabbitTemplate.convertAndSend("exchange.direct","login",map);
        try {
            strengthService.msgSend(user.getId().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    /**
     * 竞速系统的成就
     * option为2
     * @param distance
     */
    @Async
    public void speedSettlement(int id, int distance) {


        AchieveOwnerExample achieveOwnerExample = new AchieveOwnerExample();
        AchieveOwnerExample.Criteria criteria = achieveOwnerExample.createCriteria();
        criteria.andIsReachEqualTo(0);
        criteria.andUserIdEqualTo(id);
        List<AchieveOwner> achieveOwnerList = achieveOwnerMapper.selectByExample(achieveOwnerExample);
        for (AchieveOwner achieveOwner: achieveOwnerList ) {
            if(achieveOwner.getIsReach() == 0 && achieveOwner.getCategory() == 2){
                // 从redis缓存里取得
                Achievement achievement = achieveService.getAchievement(achieveOwner.getAchievementId());
                int condition = achievement.getCondition();

                // 如果成功达到某一个成就，获得奖励
                if (achieveOwner.getProgress() + distance >= condition) {
                    achieveOwner.setProgress(condition);
                    achieveOwner.setIsReach(1);

                    // 0则是增加积分,1为金币奖励
                    if (achievement.getKind() == 0){
                        carbonRankingMapper.updateByUid(id,achievement.getReward());
                    } else if(achievement.getKind() == 1){
                        Coin coin = new Coin();
                        coin.setUserId(id);
                        coin.setCoinNumber(achievement.getReward());
                        coin.setWeekNumber(achievement.getReward());
                        coinMapper.updateByUid(coin);
                    }
                } else {
                    achieveOwner.setProgress(achieveOwner.getProgress() + distance);
                }
                achieveOwnerMapper.updateByPrimaryKeySelective(achieveOwner);
            }
        }


    }
}
