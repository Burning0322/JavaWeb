package com.rh.webapplication.mapper;

import com.rh.web.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Results({
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select id,name,create_time,update_time from dept order by update_time desc")
    List<Dept> findAll();

    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept getId(Integer id);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id =#{id}")
    void update(Dept dept);
}