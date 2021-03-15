package com.mt.metro.mapper;

import com.mt.metro.entity.HistorySgame;
import com.mt.metro.entity.HistorySgameExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HistorySgameMapper {
    int countByExample(HistorySgameExample example);

    int deleteByExample(HistorySgameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HistorySgame record);

    int insertSelective(HistorySgame record);

    List<HistorySgame> selectByExample(HistorySgameExample example);

    HistorySgame selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HistorySgame record, @Param("example") HistorySgameExample example);

    int updateByExample(@Param("record") HistorySgame record, @Param("example") HistorySgameExample example);

    int updateByPrimaryKeySelective(HistorySgame record);

    int updateByPrimaryKey(HistorySgame record);
}