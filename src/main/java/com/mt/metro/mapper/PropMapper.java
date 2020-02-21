package com.mt.metro.mapper;

import com.mt.metro.entity.Prop;
import com.mt.metro.entity.PropExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PropMapper {
    int countByExample(PropExample example);

    int deleteByExample(PropExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Prop record);

    int insertSelective(Prop record);

    List<Prop> selectByExample(PropExample example);

    Prop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Prop record, @Param("example") PropExample example);

    int updateByExample(@Param("record") Prop record, @Param("example") PropExample example);

    int updateByPrimaryKeySelective(Prop record);

    int updateByPrimaryKey(Prop record);
}