package com.mt.metro;

import com.github.pagehelper.PageHelper;
import com.mt.metro.mapper.AchieveOwnerMapper;
import com.mt.metro.service.BuddySystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BuddyTest {

    @Autowired
    BuddySystemService buddySystemService;
    @Autowired
    AchieveOwnerMapper achieveOwnerMapper;


    //@Test
    public void getFriend(){
        buddySystemService.getMyFriends(1);
    }


    //@Test
    public void getAll(){
        PageHelper.startPage(1,5);
        System.out.println(achieveOwnerMapper.selectAll());

        PageHelper.startPage(2,5);
        System.out.println(achieveOwnerMapper.selectAll());
    }
}
