package com.mt.metro.service;


import com.alibaba.fastjson.serializer.PropertyFilter;
import com.mt.metro.common.JsonFilter;
import com.mt.metro.common.ResponseResult;
import com.mt.metro.entity.Dressup;
import com.mt.metro.entity.DressupExample;
import com.mt.metro.entity.DressupOwner;
import com.mt.metro.entity.DressupOwnerExample;
import com.mt.metro.mapper.DressupMapper;
import com.mt.metro.mapper.DressupOwnerMapper;
import com.mt.metro.mapper.DressupSortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("DressService")
public class DressService {
    /**
     * 装扮模块
     */

    @Autowired
    DressupSortMapper dressupSortMapper;

    @Autowired
    DressupMapper dressupMapper;

    @Autowired
    DressupOwnerMapper dressupOwnerMapper;

    //@Slave
    public ResponseResult getDress(int userId, int option) {
        Map map = new HashMap();
        List list = new ArrayList();
        DressupOwnerExample dressupOwnerExample = new DressupOwnerExample();
        DressupOwnerExample.Criteria criteria = dressupOwnerExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<DressupOwner> dressupOwnerList = dressupOwnerMapper.selectByExample(dressupOwnerExample);

        DressupExample dressupExample = new DressupExample();
        DressupExample.Criteria criteria1 = dressupExample.createCriteria();
        criteria1.andDressupIdEqualTo(option);
        List<Dressup> dressupList = dressupMapper.selectByExample(dressupExample);

        PropertyFilter profilter = (object, name, value) -> {
            if (name.equalsIgnoreCase("dressupId")) {
                //false表示last字段将被排除在外
                return false;
            }
            return true;
        };

        for (Dressup dressup : dressupList){
            map.put("hasBought",false);
            for (DressupOwner dressupOwner : dressupOwnerList){
                if (dressupOwner.getDressupId() == dressup.getId()){
                    map.put("hasBought",true);
                }
            }
            map.put("dress", JsonFilter.getJsonPreFilter(dressup, profilter));
            list.add(map);
        }

        return new ResponseResult(200,"success",list);
    }


}
