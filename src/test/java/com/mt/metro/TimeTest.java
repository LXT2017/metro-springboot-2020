package com.mt.metro;


import com.mt.metro.utils.Time;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TimeTest {

    @Test
    public void getCurrentDate() {
        System.out.println(Time.getRefreshTime());
    }


    //@Test
    public void getCurrentTime() {
        System.out.println(Time.getCurrentTime());
    }

    @Test
    public void getWeek(){
        System.out.println(Time.getRefreshWeekTime());

    }
}
