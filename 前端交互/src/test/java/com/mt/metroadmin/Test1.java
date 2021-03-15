package com.mt.metroadmin;

import com.mt.metroadmin.mapper.AchieveOwnerMapper;
import com.mt.metroadmin.mapper.AdminMapper;
import com.mt.metroadmin.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class Test1 {

    @Resource
    AdminMapper adminMapper;
    @Autowired
    UserManageService userManageService;

    @Autowired
    AchieveOwnerMapper achieveOwnerMapper;

    //@Test
    public void test2(){
        userManageService.getFeedBack(1,10);
    }

    //@Test
    public void user(){
        System.out.println(achieveOwnerMapper.selectUserAchievement(1));
    }
}
