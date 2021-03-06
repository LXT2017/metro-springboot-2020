package com.mt.metro.mapper;

import com.mt.metro.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    User1 selectInitialInfo(@Param("id") int id);

    // List<User1> selectDailyRanking();
    // List<User1> selectWeekRanking();

    List<UserCarbonRaking> selectDailyRanking(@Param("list")List<Integer> list);

    List<UserCarbonRaking> selectWeekRanking(@Param("list")List<Integer> list);

    List<MyFriend> findFriendByList(List<Integer> list);
}