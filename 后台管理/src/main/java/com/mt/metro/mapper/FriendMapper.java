package com.mt.metro.mapper;

import com.mt.metro.entity.Friend;
import com.mt.metro.entity.FriendExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FriendMapper {
    int countByExample(FriendExample example);

    int deleteByExample(FriendExample example);

    int insert(Friend record);

    int insertSelective(Friend record);

    List<Friend> selectByExample(FriendExample example);

    int updateByExampleSelective(@Param("record") Friend record, @Param("example") FriendExample example);

    int updateByExample(@Param("record") Friend record, @Param("example") FriendExample example);


    @Select("select * from friend where friend1=#{id} or friend2=#{id}")
    List<Friend> findFriendById(int id);

    @Delete("delete from friend where (friend1=#{id1} AND friend2=#{id2}) OR friend1=#{id2} AND friend2=#{id1}")
    int deleteFriend(int id1, int id2);
}