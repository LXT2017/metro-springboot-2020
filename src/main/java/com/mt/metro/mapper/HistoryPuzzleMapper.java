package com.mt.metro.mapper;

import com.mt.metro.entity.HistoryPuzzle;
import com.mt.metro.entity.HistoryPuzzleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistoryPuzzleMapper {
    int countByExample(HistoryPuzzleExample example);

    int deleteByExample(HistoryPuzzleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HistoryPuzzle record);

    int insertSelective(HistoryPuzzle record);

    List<HistoryPuzzle> selectByExample(HistoryPuzzleExample example);

    HistoryPuzzle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HistoryPuzzle record, @Param("example") HistoryPuzzleExample example);

    int updateByExample(@Param("record") HistoryPuzzle record, @Param("example") HistoryPuzzleExample example);

    int updateByPrimaryKeySelective(HistoryPuzzle record);

    int updateByPrimaryKey(HistoryPuzzle record);
}