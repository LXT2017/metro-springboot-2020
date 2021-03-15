package com.mt.metroadmin.mapper;

import com.mt.metroadmin.entity.HistoryDgame;
import com.mt.metroadmin.entity.HistoryDgameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistoryDgameMapper {
    int countByExample(HistoryDgameExample example);

    int deleteByExample(HistoryDgameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HistoryDgame record);

    int insertSelective(HistoryDgame record);

    List<HistoryDgame> selectByExample(HistoryDgameExample example);

    HistoryDgame selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HistoryDgame record, @Param("example") HistoryDgameExample example);

    int updateByExample(@Param("record") HistoryDgame record, @Param("example") HistoryDgameExample example);

    int updateByPrimaryKeySelective(HistoryDgame record);

    int updateByPrimaryKey(HistoryDgame record);
}