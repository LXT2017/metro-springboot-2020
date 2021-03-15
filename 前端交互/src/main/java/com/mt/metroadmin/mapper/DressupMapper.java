package com.mt.metroadmin.mapper;

import com.mt.metroadmin.entity.Dressup;
import com.mt.metroadmin.entity.DressupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DressupMapper {
    int countByExample(DressupExample example);

    int deleteByExample(DressupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dressup record);

    int insertSelective(Dressup record);

    List<Dressup> selectByExample(DressupExample example);

    Dressup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dressup record, @Param("example") DressupExample example);

    int updateByExample(@Param("record") Dressup record, @Param("example") DressupExample example);

    int updateByPrimaryKeySelective(Dressup record);

    int updateByPrimaryKey(Dressup record);
}