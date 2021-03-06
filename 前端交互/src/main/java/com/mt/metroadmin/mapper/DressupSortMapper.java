package com.mt.metroadmin.mapper;

import com.mt.metroadmin.entity.DressupSort;
import com.mt.metroadmin.entity.DressupSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DressupSortMapper {
    int countByExample(DressupSortExample example);

    int deleteByExample(DressupSortExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DressupSort record);

    int insertSelective(DressupSort record);

    List<DressupSort> selectByExample(DressupSortExample example);

    DressupSort selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DressupSort record, @Param("example") DressupSortExample example);

    int updateByExample(@Param("record") DressupSort record, @Param("example") DressupSortExample example);

    int updateByPrimaryKeySelective(DressupSort record);

    int updateByPrimaryKey(DressupSort record);
}