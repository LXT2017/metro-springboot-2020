package com.mt.metro.service;

import com.mt.metro.utils.ResponseResult;
import com.mt.metro.entity.Coin;
import com.mt.metro.mapper.CoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SpeedService {


    @Autowired
    CoinMapper coinMapper;
    @Autowired
    AsyncService asyncService;




    /**
     * 这里模拟列车信息
     * @param current
     * @param destination
     * @return
     */
    public ResponseResult getMetroInfo(String current, String destination) {
        int trainid = 12345678;
        long destTime = System.currentTimeMillis();
        int passCount = 1;
        Map eachTime = null;
        if(current.equals("文泽路")){
            passCount = 3;
            eachTime = new HashMap();
            eachTime.put("1",10);
            eachTime.put("2",25);
            eachTime.put("3",35);
        } else if (current.equals("下沙西")){
            passCount = 2;
            eachTime = new HashMap();
            eachTime.put("1",8);
            eachTime.put("2",18);
        } else {
            eachTime = new HashMap();
            eachTime.put("1",3);
        }
        Map map = new HashMap();
        map.put("id",trainid);
        map.put("destTime",destTime);
        map.put("passCount",passCount);
        map.put("eachTime", eachTime);
        return new ResponseResult(200,"success",map);

    }


    /**
     * 金币的录入和计算
     * @return
     */
    public ResponseResult settlement(int id, int coin, int distance, int loseCoin) {

        Coin coin1 = new Coin();
        coin1.setWeekNumber(coin);
        coin1.setCoinNumber(coin-loseCoin);
        coin1.setUserId(id);
        coinMapper.updateByUid(coin1);


        /**
         * 这里需要进行路程业务逻辑
         */
        asyncService.speedSettlement(id,distance);

        return new ResponseResult(200,"success",null);
    }
}
