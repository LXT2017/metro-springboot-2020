package com.mt.metro.mapper;

import com.mt.metro.entity.HistoryIntegral;
import com.mt.metro.entity.HistoryIntegralExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HistoryIntegralMapper {
    int countByExample(HistoryIntegralExample example);

    int deleteByExample(HistoryIntegralExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HistoryIntegral record);

    int insertSelective(HistoryIntegral record);

    List<HistoryIntegral> selectByExample(HistoryIntegralExample example);

    HistoryIntegral selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HistoryIntegral record, @Param("example") HistoryIntegralExample example);

    int updateByExample(@Param("record") HistoryIntegral record, @Param("example") HistoryIntegralExample example);

    int updateByPrimaryKeySelective(HistoryIntegral record);

    int updateByPrimaryKey(HistoryIntegral record);
}