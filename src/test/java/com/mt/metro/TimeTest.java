package com.mt.metro;


import com.mt.metro.common.Time;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TimeTest {

    @Test
    public void getCurrentDate(){
        System.out.println(Time.getCurrentDate());
    }


    @Test
    public void getCurrentTime(){
        System.out.println(Time.getCurrentTime());
    }
}
