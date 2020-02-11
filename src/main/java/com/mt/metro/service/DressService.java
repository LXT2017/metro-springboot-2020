package com.mt.metro.service;


import com.alibaba.fastjson.serializer.PropertyFilter;
import com.mt.metro.common.JsonFilter;
import com.mt.metro.entity.Dressup;
import com.mt.metro.entity.DressupExample;
import com.mt.metro.mapper.DressupMapper;
import com.mt.metro.mapper.DressupSortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    //@Slave
    public Object getDress(Dressup dressup){
        Map map = new HashMap();

        DressupExample example = new DressupExample();
        DressupExample.Criteria criteria = example.createCriteria();
        criteria.andDressupIdEqualTo(dressup.getDressupId());

        PropertyFilter profilter = new PropertyFilter(){
            @Override
            public boolean apply(Object object, String name, Object value) {
                if(name.equalsIgnoreCase("dressupId")){
                    //false表示last字段将被排除在外
                    return false;
                }
                return true;
            }

        };

        List<Dressup> list = dressupMapper.selectByExample(example);
        map.put("dress", JsonFilter.getJsonPreFilter(list,profilter));
        return map;
    }


}
