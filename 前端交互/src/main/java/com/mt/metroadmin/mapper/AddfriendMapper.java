package com.mt.metroadmin.mapper;

import com.mt.metroadmin.entity.Addfriend;
import com.mt.metroadmin.entity.AddfriendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddfriendMapper {
    int countByExample(AddfriendExample example);

    int deleteByExample(AddfriendExample example);

    int insert(Addfriend record);

    int insertSelective(Addfriend record);

    List<Addfriend> selectByExample(AddfriendExample example);

    int updateByExampleSelective(@Param("record") Addfriend record, @Param("example") AddfriendExample example);

    int updateByExample(@Param("record") Addfriend record, @Param("example") AddfriendExample example);
}