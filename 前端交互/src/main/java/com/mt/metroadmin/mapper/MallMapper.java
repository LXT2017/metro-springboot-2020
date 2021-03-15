package com.mt.metroadmin.mapper;

import com.mt.metroadmin.entity.Mall;
import com.mt.metroadmin.entity.MallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallMapper {
    int countByExample(MallExample example);

    int deleteByExample(MallExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mall record);

    int insertSelective(Mall record);

    List<Mall> selectByExample(MallExample example);

    Mall selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mall record, @Param("example") MallExample example);

    int updateByExample(@Param("record") Mall record, @Param("example") MallExample example);

    int updateByPrimaryKeySelective(Mall record);

    int updateByPrimaryKey(Mall record);
}