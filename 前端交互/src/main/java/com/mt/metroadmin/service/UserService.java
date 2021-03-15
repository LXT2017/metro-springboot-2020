package com.mt.metroadmin.service;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.github.pagehelper.PageHelper;
import com.mt.metroadmin.common.ResponseResult;
import com.mt.metroadmin.entity.*;
import com.mt.metroadmin.mapper.AchieveOwnerMapper;
import com.mt.metroadmin.mapper.AchievementMapper;
import com.mt.metroadmin.mapper.UserMapper;
import com.mt.metroadmin.utils.JsonFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shawn
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    AchieveOwnerMapper achieveOwnerMapper;

    @Autowired
    AchievementMapper achievementMapper;

    @Autowired
    CacheService cacheService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    IpAndPort ipAndPort;

    private final Logger logger = LogManager.getLogger(this.getClass());

    // 精确或者总体查询
    public ResponseResult getUser(int id, int pageNum, int pageSize) {
        if(id == 0){
            PageHelper.startPage(pageNum,pageSize);
            List<User> userList = userMapper.selectByExample(null);
            return new ResponseResult(200,"success",userList);
        }else {
            User user = userMapper.selectByPrimaryKey(id);
            if(user == null){
                return new ResponseResult(400,"没有找到该用户",null);
            }
            return new ResponseResult(200,"success",user);
        }

    }

    /**
     * 模糊查询
     * @param nickname
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ResponseResult getUserFuzzy(String nickname, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNicknameLike("%"+nickname+"%");
        List<User> userList = userMapper.selectByExample(userExample);
        return new ResponseResult(200,"sucess",userList);
    }


    //用户具体信息查询
    public ResponseResult getUserDetail(int id) {
        UserDetail userDetail = userMapper.selectUserDetail(id);
        if(userDetail == null){
            return new ResponseResult(400,"没有该用户信息",null);
        }
        Map map = new HashMap();
        List<Integer> list = achieveOwnerMapper.selectUserAchievement(id);
        List<Achievement> achievementList = new ArrayList<>();
        for (int i:list) {
            achievementList.add(cacheService.getAchievement(i));
        }

        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Achievement.class, "name","achieveUrl");


        map.put("userInfo",userDetail);
        map.put("achieve",JsonFilter.getJsonFilter(achievementList,filter));
        return new ResponseResult(200,"sucess",map);
    }




    public ResponseResult pushMessageToUser(String id,String message) {
        //使用postForObject请求接口
        //代表服务器信息
        int code = 200;
        Map map = new HashMap(16);
        map.put("code",code);
        map.put("msg",message);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("msg", JSONObject.toJSONString(map));
        params.add("id",id);
        String url="http://"+ipAndPort.getIp()+":"+ ipAndPort.getPort() + "/"+ ipAndPort.getName() +"/web/sendInfo";
        int result = restTemplate.postForObject(url, params, Integer.class);
        System.out.println("result1==================" + result);
        logger.info("单体推送成功");
        if(result == 200){
            return new ResponseResult(200,"发送成功",null);
        }else {
            return new ResponseResult(400,"发送失败或者用户不在线",null);
        }

    }

    /**
     * 推送所有
     */
    public ResponseResult pushMessage(String message) {
        //使用postForObject请求接口
        //代表服务器信息
        int code = 200;
        Map map = new HashMap(16);
        map.put("code",code);
        map.put("msg",message);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("msg", JSONObject.toJSONString(map));
        String url="http://"+ipAndPort.getIp()+":"+ ipAndPort.getPort() + "/"+ ipAndPort.getName()+"/web/sendAll";
        int result = restTemplate.postForObject(url, params, Integer.class);
        System.out.println("result1==================" + result);
        logger.info("群推送成功");
        return new ResponseResult(200,"发送成功",null);

    }

}
