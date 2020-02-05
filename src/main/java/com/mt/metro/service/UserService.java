package com.mt.metro.service;

import com.mt.metro.common.ResponseResult;
import com.mt.metro.common.Time;
import com.mt.metro.entity.*;
import com.mt.metro.mapper.CarbonRankingMapper;
import com.mt.metro.mapper.HistoryIntegralMapper;
import com.mt.metro.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.List;
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
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    TokenService tokenService;

    @Autowired
    private CarbonRankingMapper carbonRankingMapper;


    @Autowired
    HistoryIntegralMapper historyIntegralMapper;

    //在这里使用注解来选择数据源
    //@Slave
    public User findUserByUId(User user){

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUIdEqualTo(user.getuId());
        List<User> user1 = userMapper.selectByExample(userExample);
        System.out.println(user1);
        //没有注册过就先注册
        if(user1.size() == 0){
            return null;
        }
        return user1.get(0);
    }


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
            code=100;
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
            HistoryIntegral historyIntegral = new HistoryIntegral(null,1,new Date(),"签到",id);
            historyIntegralMapper.insertSelective(historyIntegral);
            //这里还需要加一个排行的

            return new ResponseResult(100,"success",null);
        }catch (Exception e){
            throw new RuntimeException("签到失败");
        }

    }


    //注册新用户
    //@Master
    public User registry(User user){
        userMapper.insertSelective(user);
        return user;
    }


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




    public CarbonRanking getCarbonRanking(int uid){
        CarbonRankingExample example = new CarbonRankingExample();
        CarbonRankingExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(uid);
        try {
            List<CarbonRanking> list = carbonRankingMapper.selectByExample(example);
            if(list.size()==0){
                return null;
            }else{
                return list.get(0);
            }
        }catch (Exception e){
            throw  new RuntimeException("数据库出错");
        }

    }
}
