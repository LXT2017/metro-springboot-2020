package com.mt.metro.service;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.mt.metro.common.JsonFilter;
import com.mt.metro.common.ResponseResult;
import com.mt.metro.common.SignDay;
import com.mt.metro.common.Time;
import com.mt.metro.entity.*;
import com.mt.metro.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    GameMapper gameMapper;

    @Autowired
    AsyncService asyncService;


    //获取初始化资源
    //@Slave
    public Map getInitialInfo(User user) {
        Map map = new HashMap();
        User1 user1 = null;
        if (user != null) {
            user1 = userMapper.selectInitialInfo(user.getId());
            if (user1 == null) {
                System.out.println("多数据表异常");
            }
        }
        Parameter parameter = parameterMapper.selectByPrimaryKey(1);

        initialResource(user);

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


        map.put("user", user1);
        map.put("param", parameter);
        map.put("trainInfo", getSubwayInfo());
        map.put("notice", getNotice());

        return map;
    }


    /**
     * 用户游戏登录时间的统计
     * 存入redis
     * @param user
     */
    public void initialResource(User user){
        // 统计在线时长
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set("online" + user.getId(),System.currentTimeMillis(),Time.getRefreshTime(),TimeUnit.SECONDS);



    }

    //模仿列车信息
    public Map getSubwayInfo() {
        Map map = new HashMap();
        map.put("first", 2);
        map.put("second", 8);
        return map;
    }


    // 其他需要初始化的的信息


    //在这里使用注解来选择数据源
    //@Slave
    public Object findUserByUId(User user) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUIdEqualTo(user.getuId());
        List<User> user1 = userMapper.selectByExample(userExample);
        System.out.println(user1);
        //没有注册过就先注册
        if (user1.size() == 0) {
            System.out.println("用户不存在");
            return registry(user);
        }
        return user1.get(0);
    }


    //注册新用户
    //@Master
    @Transactional(rollbackFor = Exception.class)
    public User registry(User user) {

        // 多线程进行新注册用户的初始化
        asyncService.achievementInitial(user);




        /**
         * 默认的事务规则是遇到运行异常（RuntimeException）
         * 和程序错误（Error）才会回滚。
         */
        user.setNickname("匿名用户");
        user.setCurrentStrength(100);
        userMapper.insertSelective(user);
        System.out.println(user);

        // 新登录用户金币初始化
        Coin coin = new Coin();
        coin.setCoinNumber(0);
        coin.setWeekNumber(0);
        coin.setUserId(user.getId());
        coinMapper.insertSelective(coin);


        /**
         * 初始化签到信息
          */
        initialSignIn(user.getId());

        // 初始化碳积分排行
        CarbonRanking carbonRanking = new CarbonRanking(0, 0, 0, -1, -1);
        carbonRanking.setUserId(user.getId());
        carbonRankingMapper.insertSelective(carbonRanking);


        // 初始化用户的游戏登录时间表
        Game game = new Game();
        game.setUserId(user.getId());
        gameMapper.insertSelective(game);

        return user;
    }

    /**
     * 初始化签到信息到redis
     * @param id
     * @return
     */
    public void initialSignIn(int id){
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        // 签到了几天了
        String signcountkey = "signcount" + id;
        // 用户的具体签到信息
        String signkey = "sign" + id;
        SignDay signDay = null;
        operations.set(signcountkey,0,Time.getRefreshWeekTime(),TimeUnit.SECONDS);
        signDay = new SignDay(0,0,0,0,0,0,0);
        operations.set(signcountkey,0,Time.getRefreshWeekTime(),TimeUnit.SECONDS);
        operations.set(signkey,signDay,Time.getRefreshWeekTime(),TimeUnit.SECONDS);
    }


    /**
     * 公告内容
     * @return
     */
    public String getNotice() {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        Notice notice = (Notice)operations.get("notice");

        if (notice == null) {
            return null;
        } else {
            return notice.getContent();
        }
    }

    /////////////////////////////////////////////////////////////////////////


    public String getUserToken(String id) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String token;
        //判断redis中是否有键为key的缓存
        boolean hasKey = redisTemplate.hasKey(id);

        if (hasKey) {
            token = operations.get(id);
            System.out.println("从缓存中获得数据：" + token);
        } else {
            token = null;
            System.out.println("数据不存在");
            throw new RuntimeException("未经授权，请重新登录");
        }
        return token;
    }

    



    //签到查询
    public ResponseResult querySignIn(int id) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        // 签到了几天了
        String signcountkey = "signcount" + id;
        String signkey = "sign" + id;
        SignDay signDay = null;
        // 如果没有签到信息就新建
        if(operations.get(signcountkey) == null){
            initialSignIn(id);
        }

        Map map = new HashMap();
        int num = (int)operations.get(signcountkey);
        map.put("signAllDaysCount",num);
        map.put("signDay",operations.get(signkey));
        map.put("coinNum",getCoinNum(num));


        String key = Time.getCurrentDate() + id;
        String message;
        int code;
        String value = (String)operations.get(key);
        if (value == null) {
            code = 501;
            message = "今日未签到";
        } else {
            code = 200;
            message = "今日已签到";
        }
        return new ResponseResult(code, message, map);
    }



    //能获得多少金币
    public int getCoinNum(int i){
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        Sign sign = (Sign)operations.get("sign");
        int coinNum = 0;
        i = i + 1;
        switch (i){
            case 1:coinNum=sign.getOne();break;
            case 2:coinNum=sign.getTwo();break;
            case 3:coinNum=sign.getThree();break;
            case 4:coinNum=sign.getFour();break;
            case 5:coinNum=sign.getFive();break;
            case 6:coinNum=sign.getSix();break;
            case 7:coinNum=sign.getSeven();break;
        }
        return coinNum;
    }

    // 当前日期变成1，代表已签到
    public void setSignDay(int id){
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        String signkey = "sign" + id;
        SignDay signDay = (SignDay)operations.get(signkey);
        int i = Time.getWeek();
        switch (i){
            case 1:signDay.setMonday(1);break;
            case 2:signDay.setTuesday(1);break;
            case 3:signDay.setWednesday(1);break;
            case 4:signDay.setThursday(1);break;
            case 5:signDay.setFriday(1);break;
            case 6:signDay.setSaturday(1);break;
            case 7:signDay.setSunday(1);break;
        }
        operations.set(signkey,signDay,Time.getRefreshWeekTime(),TimeUnit.SECONDS);
    }



    //签到
    //@Master

    public ResponseResult signIn(int id) {
        try {
            String signcountkey = "signcount" + id;

            ValueOperations<String, Object> operations = redisTemplate.opsForValue();
            String key = Time.getCurrentDate() + id;
            if(operations.get(key) != null){
                return new ResponseResult(400, "不可重复签到", null);
            }

            operations.set(key, "true", Time.getRefreshTime(), TimeUnit.SECONDS);
            //HistoryIntegral historyIntegral = new HistoryIntegral(null,1,new Date(),"签到",id);
            //historyIntegralMapper.insertSelective(historyIntegral);
            int signcount = (int)operations.get(signcountkey);
            operations.set(signcountkey,signcount+1,Time.getRefreshWeekTime(),TimeUnit.SECONDS);
            setSignDay(id);
            //签到加积分
            Coin coin = new Coin();
            coin.setUserId(id);
            coin.setCoinNumber(getCoinNum(signcount));

            System.out.println(getCoinNum(signcount)+"?????");

            coinMapper.updateByUid(coin);
            return new ResponseResult(200, "签到成功", null);
        } catch (Exception e) {
            throw new RuntimeException("签到失败");
        }

    }


    /////////////////////////////////////////////////////////////////


    //修改个人信息
    //@Master
    public int infoModify(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(user.getId());
        try {
            int i = userMapper.updateByExampleSelective(user, example);
            return i;
        } catch (Exception e) {
            throw new RuntimeException("数据库出错");
        }
    }


    /*
    排行，只需返回用户昵称和碳积分
    日排行和周排行
     */
    public Object getCarbonRanking(int option) {
        Map map = new HashMap();
        SimplePropertyPreFilter filter1 = new SimplePropertyPreFilter(
                User1.class, "nickname", "dailyScore","headPortrait");
        SimplePropertyPreFilter filter2 = new SimplePropertyPreFilter(
                User1.class, "nickname", "weekScore","headPortrait");
        List<User1> user1 = null;

        if (option == 1) {
            user1 = userMapper.selectDailyRanking();
            map.put("dailyRanking", JsonFilter.getJsonFilter(user1, filter1));
            System.out.println(user1);
        } else if (option == 2) {
            user1 = userMapper.selectWeekRanking();
            map.put("weekRanking", JsonFilter.getJsonFilter(user1, filter2));
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
