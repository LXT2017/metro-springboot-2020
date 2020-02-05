package com.mt.metro.mapper;

import com.mt.metro.entity.DressupSort;
import com.mt.metro.entity.DressupSortExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DressupSortMapper {
    int countByExample(DressupSortExample example);

    int deleteByExample(DressupSortExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DressupSort record);

    int insertSelective(DressupSort record);

    List<DressupSort> selectByExample(DressupSortExample example);

    DressupSort selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DressupSort record, @Param("example") DressupSortExample example);

    int updateByExample(@Param("record") DressupSort record, @Param("example") DressupSortExample example);

    int updateByPrimaryKeySelective(DressupSort record);

    int updateByPrimaryKey(DressupSort record);

    //查询所有
    List<DressupSort> selectAll();
}