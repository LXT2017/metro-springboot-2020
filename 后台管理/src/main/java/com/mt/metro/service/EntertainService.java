package com.mt.metro.service;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.mt.metro.utils.JsonFilter;
import com.mt.metro.utils.ResponseResult;
import com.mt.metro.entity.Coin;
import com.mt.metro.entity.User1;
import com.mt.metro.mapper.CoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntertainService {
    @Autowired
    CoinMapper coinMapper;
    @Autowired
    BuddySystemService buddySystemService;


    @Transactional
    public ResponseResult settlement(int id, int coinNum) {

        List<Integer> myfriendIdList = buddySystemService.getMyFriendsIdList(id);
        myfriendIdList.add(id);


        Coin coin = new Coin();
        coin.setUserId(id);
        coin.setCoinNumber(coinNum);
        coin.setWeekNumber(coinNum);
        coinMapper.updateByUid(coin);

        List<User1> list = coinMapper.selectFriendsCoinRanking(myfriendIdList);
        System.out.println(list);

        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(
                User1.class, "nickname", "weekNumber","headPortrait");
        return new ResponseResult(200,"success", JsonFilter.getJsonFilter(list,filter));
    }
}
