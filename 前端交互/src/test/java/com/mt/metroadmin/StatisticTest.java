package com.mt.metroadmin;

import com.mt.metroadmin.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StatisticTest {

    @Autowired
    StatisticsService statisticsService;

    //@Test
    public  void getCityTest(){
        //statisticsService.getAllCity();
        System.out.println(statisticsService.getTotalVisitsNow(5));
    }
}
