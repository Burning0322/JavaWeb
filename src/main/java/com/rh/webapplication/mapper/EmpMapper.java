package com.rh.webapplication.mapper;

import com.rh.web.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {
    /**
     * 查询总记录数
     */
    @Select("Select count(*) from emp e left join dept d on e.dept_id=d.id")
    public Long count();

    /**
     * 分页查询
     * @param start
     * @param pageSize
     * @return
     */
    @Select("Select e.*,e.name from emp e left join dept d on e.dept_id=d.id order by e.update_time desc limit #{start},#{pageSize}")
    public List<Emp> list(Integer start,Integer pageSize);
}
