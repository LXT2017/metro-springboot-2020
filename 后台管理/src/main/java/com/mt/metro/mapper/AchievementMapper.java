package com.mt.metro.mapper;

import com.mt.metro.entity.AchieveResponse;
import com.mt.metro.entity.Achievement;
import com.mt.metro.entity.AchievementExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AchievementMapper {
    int countByExample(AchievementExample example);

    int deleteByExample(AchievementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Achievement record);

    int insertSelective(Achievement record);

    List<Achievement> selectByExample(AchievementExample example);
    //这里不知道为什么有错误
    Achievement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Achievement record, @Param("example") AchievementExample example);

    int updateByExample(@Param("record") Achievement record, @Param("example") AchievementExample example);

    int updateByPrimaryKeySelective(Achievement record);

    int updateByPrimaryKey(Achievement record);

    @Select("select * from achievement where category = #{option}")
    @Results(value = {
            @Result(column = "achieve_url", property = "achieveUrl")
    })
    List<AchieveResponse> getAllAchievement(int option);

    @Select("select * from achievement")
    @Results(value = {
            @Result(column = "achieve_url", property = "achieveUrl")
    })
    List<Achievement> getAll();

    @Select("select * from achievement where id = #{id}")
    @Results(value = {
            @Result(column = "achieve_url", property = "achieveUrl")
    })
    Achievement selectById(int id);
}