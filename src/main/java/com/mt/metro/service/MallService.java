package com.mt.metro.service;

import com.mt.metro.entity.MallExample;
import com.mt.metro.mapper.MallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MallService {

    @Autowired
    MallMapper mallMapper;


    //@Slave
    public Map getMallInfo(int option){
        MallExample example = new MallExample();
        MallExample.Criteria criteria = example.createCriteria();
        if(option == 1){
            criteria.andKindEqualTo("现金券");
        }else{
            criteria.andKindEqualTo("礼品");
        }
        Map map = new HashMap();
        map.put("commodity",mallMapper.selectByExample(example));
        return map;
    }


}
