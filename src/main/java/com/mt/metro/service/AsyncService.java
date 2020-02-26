package com.mt.metro.service;

import com.mt.metro.entity.*;
import com.mt.metro.mapper.AchieveOwnerMapper;
import com.mt.metro.mapper.AchievementMapper;
import com.mt.metro.mapper.CarbonRankingMapper;
import com.mt.metro.mapper.CoinMapper;
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
    CoinMapper coinMapper;
    @Autowired
    CarbonRankingMapper carbonRankingMapper;

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
