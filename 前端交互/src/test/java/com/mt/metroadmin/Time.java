package com.mt.metroadmin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Time {

    @Test
    public void getBeforeTimeTest(){
        System.out.println(com.mt.metroadmin.utils.Time.getBeforeDaysTime(1));
    }
}
