package com.mt.metro.mapper;

import com.mt.metro.entity.AchieveOwner;
import com.mt.metro.entity.AchieveOwnerExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AchieveOwnerMapper {
    int countByExample(AchieveOwnerExample example);

    int deleteByExample(AchieveOwnerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AchieveOwner record);

    int insertSelective(AchieveOwner record);

    List<AchieveOwner> selectByExample(AchieveOwnerExample example);

    AchieveOwner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AchieveOwner record, @Param("example") AchieveOwnerExample example);

    int updateByExample(@Param("record") AchieveOwner record, @Param("example") AchieveOwnerExample example);

    int updateByPrimaryKeySelective(AchieveOwner record);

    int updateByPrimaryKey(AchieveOwner record);

    @Select("select * from achieve_owner")
    List<AchieveOwner> selectAll();
}