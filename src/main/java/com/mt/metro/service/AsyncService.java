package com.mt.metro.service;

import com.mt.metro.entity.AchieveOwner;
import com.mt.metro.entity.AchieveOwnerExample;
import com.mt.metro.entity.Achievement;
import com.mt.metro.entity.User;
import com.mt.metro.mapper.AchieveOwnerMapper;
import com.mt.metro.mapper.AchievementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsyncService {

    @Autowired
    AchievementMapper achievementMapper;
    @Autowired
    AchieveOwnerMapper achieveOwnerMapper;
    @Autowired
    AchieveService achieveService;
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
                int condition = achieveService.getAchievement(achieveOwner.getAchievementId()).getCondition();
                if (achieveOwner.getProgress() + distance >= condition) {
                    achieveOwner.setProgress(condition);
                    achieveOwner.setIsReach(1);
                } else {
                    achieveOwner.setProgress(achieveOwner.getProgress() + distance);
                }
                achieveOwnerMapper.updateByPrimaryKeySelective(achieveOwner);
            }
        }


    }
}
