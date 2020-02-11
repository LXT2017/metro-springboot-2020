package com.mt.metro.service;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.mt.metro.common.JsonFilter;
import com.mt.metro.common.ResponseResult;
import com.mt.metro.common.Time;
import com.mt.metro.entity.*;
import com.mt.metro.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author jinbin
 * @date 2018-07-08 20:52
 */
@EnableTransactionManagement
@Service("UserService")
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Resource
    RedisTemplate redisTemplate;
    @Autowired
    TokenService tokenService;
    @Autowired
    CarbonRankingMapper carbonRankingMapper;
    @Autowired
    HistoryIntegralMapper historyIntegralMapper;
    @Autowired
    CoinMapper coinMapper;
    @Autowired
    ParameterMapper parameterMapper;

    @Autowired
    FeedbackMapper feedbackMapper;

    //获取初始化资源
    //@Slave
    public Map getInitialInfo(User user){
        Map map = new HashMap();
        User1 user1 = null;
        if(user != null) {
            user1 = userMapper.selectInitialInfo(user.getId());
            if(user1 == null){
                System.out.println("多数据表异常");
            }
        }
        Parameter parameter = parameterMapper.selectByPrimaryKey(1);

        /*过滤字段
        System.out.println(parameter);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(
                Parameter.class, "addition");
        System.out.println(JSONObject.toJSONString(parameter, filter));



        过滤不必要的字段
        final String[] arr = new String[] { "ticketNo", "status", "updateTime",  "createTime" };
        PropertyFilter propertyFilter = new PropertyFilter() {
        public boolean apply(Object object, String name, Object value) {
        for (String string : arr) {
            if (name.equalsIgnoreCase(string)) {
                return false;// 过滤掉
            }
        }
             return true;// 不过滤
            }
        };
         json = JSON.toJSONString(user, propertyFilter);
        System.out.println(json);
        */


        map.put("user",user1);
        map.put("param",parameter);
        map.put("trainInfo",getSubwayInfo());
        map.put("notice",getNotice());

        return map;
    }



    //模仿列车信息
    public Map getSubwayInfo(){
        Map map = new HashMap();
        map.put("first",2);
        map.put("second",8);
        return map;
    }


    //在这里使用注解来选择数据源
    //@Slave
    public Object findUserByUId(User user){

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUIdEqualTo(user.getuId());
        List<User> user1 = userMapper.selectByExample(userExample);
        System.out.println(user1);
        //没有注册过就先注册
        if(user1.size() == 0){
            System.out.println("用户不存在");
            return registry(user);
        }
        return user1.get(0);
    }




    //注册新用户
    //@Master
    public User registry(User user){
        user.setNickname("匿名用户");
        userMapper.insertSelective(user);

        Coin coin = new Coin();
        coin.setCoinNumber(0);
        coin.setUserId(user.getId());
        coinMapper.insertSelective(coin);

        CarbonRanking carbonRanking = new CarbonRanking(0,0,0,-1,-1);
        carbonRanking.setUserId(user.getId());
        carbonRankingMapper.insertSelective(carbonRanking);
        return user;
    }



    public String getNotice(){
        ValueOperations<String, Notice> operations = redisTemplate.opsForValue();
        Notice notice = operations.get("notice");
        if(notice == null){
            return null;
        }else {
            return notice.getContent();
        }
    }

    /////////////////////////////////////////////////////////////////////////


    public String getUserToken(String id){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String token;
        //判断redis中是否有键为key的缓存
        boolean hasKey = redisTemplate.hasKey(id);

        if (hasKey) {
            token = operations.get(id);
            System.out.println("从缓存中获得数据："+token);
        } else {
            token = null;
            System.out.println("数据不存在");
            throw new RuntimeException("未经授权，请重新登录");
        }
        return token;
    }

    //签到查询
    public ResponseResult querySignIn(int id){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String key = Time.getCurrentDate()+id;
        String message;
        int code;
        String value = operations.get(key);
        if(value == null){
            code=501;
            message = "今日未签到";
        }else{
            code=200;
            message = "今日已签到";
        }
        return new ResponseResult(code,message,null);
    }

    //签到
    //@Master
    public ResponseResult signIn(int id){
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            String key = Time.getCurrentDate()+id;
            operations.set(key,"true",Time.getRefreshTime(), TimeUnit.SECONDS);
            //HistoryIntegral historyIntegral = new HistoryIntegral(null,1,new Date(),"签到",id);
            //historyIntegralMapper.insertSelective(historyIntegral);
            //签到加积分
            Coin coin = new Coin();
            coin.setUserId(id);
            coin.setCoinNumber(10);
            coinMapper.updateByUid(coin);
            return new ResponseResult(200,"签到成功",null);
        }catch (Exception e){
            throw new RuntimeException("签到失败");
        }

    }


/////////////////////////////////////////////////////////////////


    //修改个人信息
    //@Master
    public int infoModify(User user){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(user.getId());
        try {
            int i = userMapper.updateByExampleSelective(user,example);
            return i;
        }catch (Exception e){
            throw  new RuntimeException("数据库出错");
        }
    }



    /*
    排行，只需返回用户昵称和碳积分
    日排行和周排行
     */
    public Object getCarbonRanking(int option){
        Map map = new HashMap();
        SimplePropertyPreFilter filter1 = new SimplePropertyPreFilter(
                User1.class, "nickname","dailyScore");
        SimplePropertyPreFilter filter2 = new SimplePropertyPreFilter(
                User1.class, "nickname","weekScore");
        List<User1> user1 = null;

        if(option == 1){
            user1 = userMapper.selectDailyRanking();
            map.put("dailyRanking",JsonFilter.getJsonFilter(user1,filter1));
        }else if(option == 2){
            user1 = userMapper.selectWeekRanking();
            map.put("weekRanking", JsonFilter.getJsonFilter(user1,filter2));
        }
        return map;
    }



    //@Master
    public Boolean postFeedBack(Feedback feedback) {

        feedback.setfDate(Time.getDateCurrentTime());
        int i = feedbackMapper.insertSelective(feedback);
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }
}
