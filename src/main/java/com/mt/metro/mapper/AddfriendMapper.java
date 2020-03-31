package com.mt.metro.mapper;

import com.mt.metro.entity.Addfriend;
import com.mt.metro.entity.MyFriend;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AddfriendMapper {

    int addFriend(Addfriend addfriend);

    List<Addfriend> findFriendRequest(int friend2Id);

    List<Addfriend> responseMessage (int friend1Id);


    int delFriendRequest(int id);


    @Select("select id,nickname from user where id=#{id}")
    @Results(value = {
            @Result(column = "id",property = "id"),
            @Result(column = "nickname",property = "friendName")})
    Addfriend findUserByUserId(int id);

    int friendRequest(int id1, int id2, String friend2_allow);



    List<MyFriend> findFriendsByLocation(@Param("id")int id,@Param("list")List<Integer> list);

    MyFriend selectUserById(int id);

    List<MyFriend> selectUserByName(@Param("id") int id, @Param("name") String name,@Param("list") List<Integer> list);
}