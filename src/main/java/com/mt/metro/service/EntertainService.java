package com.mt.metro.service;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.mt.metro.common.JsonFilter;
import com.mt.metro.common.ResponseResult;
import com.mt.metro.entity.Coin;
import com.mt.metro.entity.User1;
import com.mt.metro.mapper.CoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntertainService {
    @Autowired
    CoinMapper coinMapper;


    public ResponseResult settlement(int id, int coinNum) {
        Coin coin = new Coin();
        coin.setUserId(id);
        coin.setCoinNumber(coinNum);
        coin.setWeekNumber(coinNum);
        coinMapper.updateByUid(coin);

        List<User1> list = coinMapper.selectCoinRanking();
        System.out.println(list);

        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(
                User1.class, "nickname", "weekNumber","headPortrait");
        return new ResponseResult(200,"success", JsonFilter.getJsonFilter(list,filter));
    }
}
