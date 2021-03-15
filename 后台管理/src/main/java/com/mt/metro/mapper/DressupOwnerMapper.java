package com.mt.metro.mapper;

import com.mt.metro.entity.DressupOwner;
import com.mt.metro.entity.DressupOwnerExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DressupOwnerMapper {
    int countByExample(DressupOwnerExample example);

    int deleteByExample(DressupOwnerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DressupOwner record);

    int insertSelective(DressupOwner record);

    List<DressupOwner> selectByExample(DressupOwnerExample example);

    DressupOwner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DressupOwner record, @Param("example") DressupOwnerExample example);

    int updateByExample(@Param("record") DressupOwner record, @Param("example") DressupOwnerExample example);

    int updateByPrimaryKeySelective(DressupOwner record);

    int updateByPrimaryKey(DressupOwner record);
}