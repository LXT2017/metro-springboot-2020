package com.mt.metro.mapper;

import com.mt.metro.entity.PicPuzzle;
import com.mt.metro.entity.PicPuzzleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PicPuzzleMapper {
    int countByExample(PicPuzzleExample example);

    int deleteByExample(PicPuzzleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PicPuzzle record);

    int insertSelective(PicPuzzle record);

    List<PicPuzzle> selectByExample(PicPuzzleExample example);

    PicPuzzle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PicPuzzle record, @Param("example") PicPuzzleExample example);

    int updateByExample(@Param("record") PicPuzzle record, @Param("example") PicPuzzleExample example);

    int updateByPrimaryKeySelective(PicPuzzle record);

    int updateByPrimaryKey(PicPuzzle record);
}