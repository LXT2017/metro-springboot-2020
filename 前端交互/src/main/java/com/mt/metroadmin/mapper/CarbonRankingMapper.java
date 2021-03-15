package com.mt.metroadmin.mapper;

import com.mt.metroadmin.entity.CarbonRanking;
import com.mt.metroadmin.entity.CarbonRankingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}