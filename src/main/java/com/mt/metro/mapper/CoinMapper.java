package com.mt.metro.mapper;

import com.mt.metro.entity.Coin;
import com.mt.metro.entity.CoinExample;
import org.apache.ibatis.annotations.Param;

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
}