package com.mt.metroadmin.mapper;

import com.mt.metroadmin.entity.HistorySgame;
import com.mt.metroadmin.entity.HistorySgameExample;
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