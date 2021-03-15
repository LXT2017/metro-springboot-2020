package com.mt.metroadmin.service;

import com.mt.metroadmin.common.ResponseResult;
import com.mt.metroadmin.entity.Admin;
import com.mt.metroadmin.entity.AdminExample;
import com.mt.metroadmin.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 已弃用
 */
@Service("UserService")
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    TokenService tokenService;


    public ResponseResult findByUsername(Admin admin) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andPasswordEqualTo(admin.getPassword());
        criteria.andUserNameEqualTo(admin.getUserName());
        int i = adminMapper.countByExample(example);
        if (i == 0) {
            return new ResponseResult(400,"账号或密码错误",null);
        } else {
            String token = tokenService.getToken(admin);
            Map map = new HashMap();
            map.put("token",token);
            return new ResponseResult(200,"成功",map);
        }
    }

}
