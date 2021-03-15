package com.mt.metroadmin.mapper;

import com.mt.metroadmin.entity.Statistic;
import com.mt.metroadmin.entity.StatisticExample;
import com.mt.metroadmin.entity.TotalLoginVisit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StatisticMapper {
    int countByExample(StatisticExample example);

    int deleteByExample(StatisticExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Statistic record);

    int insertSelective(Statistic record);

    List<Statistic> selectByExample(StatisticExample example);

    Statistic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Statistic record, @Param("example") StatisticExample example);

    int updateByExample(@Param("record") Statistic record, @Param("example") StatisticExample example);

    int updateByPrimaryKeySelective(Statistic record);

    int updateByPrimaryKey(Statistic record);

    @Select("select s.totalnum,s.statime from statistic s where s.statime >= #{time}")
    List<TotalLoginVisit> selectTotalVisitsNow(String time);
    @Select("select s.totalnum,s.statime from statistic s where s.statime >= #{before} AND s.statime < #{now} ")
    List<TotalLoginVisit> selectTotalVisitsFrom(String before, String now);

    @Select("select * from statistic s where s.statime >= #{time} AND s.city=#{city}")
    List<Statistic> selectCityVisitsNow(String time, String city);
    @Select("select * from statistic s where s.statime >= #{before} AND s.statime < #{now} AND s.city=#{city}")
    List<Statistic> selectCityVisitsFrom(String before, String now, String city);
}