package com.mt.metroadmin.service;


import com.mt.metroadmin.common.ResponseResult;
import com.mt.metroadmin.entity.Statistic;
import com.mt.metroadmin.entity.TotalLoginVisit;
import com.mt.metroadmin.mapper.StatisticMapper;
import com.mt.metroadmin.mapper.UserMapper;
import com.mt.metroadmin.utils.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    StatisticMapper statisticMapper;

    @Resource
    RestTemplate restTemplate;

    public ResponseResult getAllCity() {

        List<String> list = userMapper.getAllCity();
        return new ResponseResult(200,"sucess",list);
    }

    // 前几天的数据
    public ResponseResult getTotalVisitsNow(int days) {
        String time = Time.getBeforeDaysTime(days);
        List<TotalLoginVisit> list = statisticMapper.selectTotalVisitsNow(time);
        return new ResponseResult(200,"sucess",list);
    }

    public ResponseResult getTotalVisitsFrom(String before, String now) {
        List<TotalLoginVisit> list = statisticMapper.selectTotalVisitsFrom(before,now);
        return new ResponseResult(200,"sucess", list);
    }


    public ResponseResult getCityVisitsNow(int days, String city) {
        String time = Time.getBeforeDaysTime(days);
        List<Statistic> list = statisticMapper.selectCityVisitsNow(time,city);
        return new ResponseResult(200,"sucess",list);
    }


    public ResponseResult getCityVisitsFrom(String before, String now, String city) {
        List<Statistic> list = statisticMapper.selectCityVisitsFrom(before,now,city);
        return new ResponseResult(200,"sucess", list);
    }

    public ResponseResult getOnlineNum() {
        String url="http://localhost/metro/web/getOnlineNum";
        int num = (int) restTemplate.getForObject(url, Object.class);
        return new ResponseResult(200,"sucess",num);
    }
}
