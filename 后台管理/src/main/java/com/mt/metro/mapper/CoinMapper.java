package com.mt.metro.mapper;

import com.mt.metro.entity.Coin;
import com.mt.metro.entity.CoinExample;
import com.mt.metro.entity.User1;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CoinMapper {
    int countByExample(CoinExample example);

    int deleteByExample(CoinExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Coin record);

    int insertSelective(Coin record);

    List<Coin> selectByExample(CoinExample example);

    Coin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Coin record, @Param("example") CoinExample example);

    int updateByExample(@Param("record") Coin record, @Param("example") CoinExample example);

    int updateByPrimaryKeySelective(Coin record);

    int updateByPrimaryKey(Coin record);

    int updateByUid(Coin coin);


    @Select("select u.nickname,u.head_portrait,c.week_number from user u,coin c where u.id=c.user_id " +
            " order by c.week_number desc")
    @Results(value = {
            @Result(column = "week_number",property = "weekNumber"),
            @Result(column = "head_portrait",property = "headPortrait")})
    List<User1> selectCoinRanking();

    @Update("update coin set week_number=0")
    int updateAllWeekCoin();

    List<User1> selectFriendsCoinRanking(List<Integer> myfriendIdList);
}