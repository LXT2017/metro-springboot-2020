package com.mt.metroadmin.mapper;

import com.mt.metroadmin.entity.Admin;
import com.mt.metroadmin.entity.AdminExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    @Select("select * from admin where user_name = #{userName}")
    @Results(value = {
            @Result(column = "user_name",property = "userName",jdbcType = JdbcType.VARCHAR)
    })
    Admin selectByUserName(String userName);



}