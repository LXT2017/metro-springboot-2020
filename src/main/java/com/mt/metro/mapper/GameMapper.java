package com.mt.metro.mapper;

import com.mt.metro.entity.Game;
import com.mt.metro.entity.GameExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GameMapper {
    int countByExample(GameExample example);

    int deleteByExample(GameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Game record);

    int insertSelective(Game record);

    List<Game> selectByExample(GameExample example);

    Game selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Game record, @Param("example") GameExample example);

    int updateByExample(@Param("record") Game record, @Param("example") GameExample example);

    int updateByPrimaryKeySelective(Game record);


    int updateByPrimaryKey(Game record);

    @Select("select * from game where user_id=#{id} limit 1")
    @Results(@Result(column = "user_id",property = "userId"))
    Game selectBySelective(Integer id);
}