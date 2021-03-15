package com.mt.metro.service;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.mt.metro.utils.JsonFilter;
import com.mt.metro.utils.ResponseResult;
import com.mt.metro.entity.AchieveOwner;
import com.mt.metro.entity.AchieveOwnerExample;
import com.mt.metro.entity.AchieveResponse;
import com.mt.metro.entity.Achievement;
import com.mt.metro.mapper.AchieveOwnerMapper;
import com.mt.metro.mapper.AchievementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AchieveService {

    @Resource
    RedisTemplate redisTemplate;

    @Autowired
    AchievementMapper achievementMapper;

    @Autowired
    AchieveOwnerMapper achieveOwnerMapper;

    /**
     * 成就称号缓存
     */
    @Cacheable(value = "achieve")
    public Achievement getAchievement(int id){
        return achievementMapper.selectById(id);
    }








    /**
     * 这里可以改进
     * 但是之前写的不想动了
     * 就这样吧
     * @param id
     * @param option
     * @return
     */
    public ResponseResult getAchievement(int id, int option){
        List<AchieveResponse> list = achievementMapper.getAllAchievement(option);


        AchieveOwnerExample example = new AchieveOwnerExample();
        AchieveOwnerExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(id);
        criteria.andCategoryEqualTo(option);
        List<AchieveOwner> achieveOwnerList = achieveOwnerMapper.selectByExample(example);


        for (AchieveResponse a : list){
            //a.setProgress("0/" + a.getCondition());
            a.setIsReach(false);
            for (AchieveOwner achieveOwner : achieveOwnerList) {
                a.setProgress(achieveOwner.getProgress() + "/" + a.getCondition());
                if (achieveOwner.getIsReach() == 1 && achieveOwner.getAchievementId() == a.getId()) {
                    a.setIsReach(true);
                }
            }
        }


        // 过滤的字符
        PropertyFilter profilter = (object, name, value) -> {
            if (name.equalsIgnoreCase("id") || name.equalsIgnoreCase("condition") ) {
                //false表示last字段将被排除在外
                return false;
            }
            return true;
        };
        return new ResponseResult(200,"sucess",JsonFilter.getJsonPreFilter(list, profilter));

    }




    public ResponseResult getAchievementCount(int userId) {
        int achievementCount = achievementMapper.countByExample(null);

        AchieveOwnerExample example = new AchieveOwnerExample();
        AchieveOwnerExample.Criteria criteria= example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andIsReachEqualTo(1);
        int deblockingCount = achieveOwnerMapper.countByExample(example);
        // 统计在线时间，当前时间减去登陆时间
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        long loginTime = (System.currentTimeMillis() - (long) operations.get("online"+userId))/1000/60;
        Map map = new HashMap();
        map.put("achievementCount",achievementCount);
        map.put("lockedAchieve",deblockingCount);
        map.put("onlineTime",loginTime);
        return new ResponseResult(200,"success",map);
    }
}
