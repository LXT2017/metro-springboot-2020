package com.mt.metro;

import com.mt.metro.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AsyncTest {

    @Autowired
    AsyncService asyncService;


   // @Test
    public void achievementAsyncTest(){
        asyncService.achievementInitial(null);
    }
}
