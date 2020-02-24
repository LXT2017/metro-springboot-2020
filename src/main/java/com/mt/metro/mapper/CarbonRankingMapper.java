package com.mt.metro.mapper;

import com.mt.metro.entity.CarbonRanking;
import com.mt.metro.entity.CarbonRankingExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CarbonRankingMapper {
    int countByExample(CarbonRankingExample example);

    int deleteByExample(CarbonRankingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarbonRanking record);

    int insertSelective(CarbonRanking record);

    List<CarbonRanking> selectByExample(CarbonRankingExample example);

    CarbonRanking selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarbonRanking record, @Param("example") CarbonRankingExample example);

    int updateByExample(@Param("record") CarbonRanking record, @Param("example") CarbonRankingExample example);

    int updateByPrimaryKeySelective(CarbonRanking record);

    int updateByPrimaryKey(CarbonRanking record);

    @Update("update carbon_ranking set daily_score=daily_score+#{score}," +
            "week_score=week_score+#{score}," +
            "total_score=total_score+#{score} where user_id=#{userId}")
    int updateByUid(int userId, int score);
}