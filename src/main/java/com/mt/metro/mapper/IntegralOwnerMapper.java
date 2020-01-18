package com.mt.metro.mapper;

import com.mt.metro.entity.IntegralOwner;
import com.mt.metro.entity.IntegralOwnerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntegralOwnerMapper {
    int countByExample(IntegralOwnerExample example);

    int deleteByExample(IntegralOwnerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IntegralOwner record);

    int insertSelective(IntegralOwner record);

    List<IntegralOwner> selectByExample(IntegralOwnerExample example);

    IntegralOwner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IntegralOwner record, @Param("example") IntegralOwnerExample example);

    int updateByExample(@Param("record") IntegralOwner record, @Param("example") IntegralOwnerExample example);

    int updateByPrimaryKeySelective(IntegralOwner record);

    int updateByPrimaryKey(IntegralOwner record);
}