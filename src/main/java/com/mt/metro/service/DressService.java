package com.mt.metro.service;


import com.mt.metro.entity.Dressup;
import com.mt.metro.entity.DressupExample;
import com.mt.metro.entity.DressupSort;
import com.mt.metro.mapper.DressupMapper;
import com.mt.metro.mapper.DressupSortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DressService")
public class DressService {
    /**
     * 装扮模块
     */

    @Autowired
    DressupSortMapper dressupSortMapper;

    @Autowired
    DressupMapper dressupMapper;


    //获取所有分类装扮
    public List<DressupSort> getDressSort(){
        return dressupSortMapper.selectAll();
    }


    public List<Dressup> getDress(Dressup dressup){
        DressupExample example = new DressupExample();
        DressupExample.Criteria criteria = example.createCriteria();
        criteria.andDressupIdEqualTo(dressup.getDressupId());
        try {
            List<Dressup> list = dressupMapper.selectByExample(example);
            return list;
        }catch (Exception e){
            throw  new RuntimeException("数据库出错");
        }
    }
}
