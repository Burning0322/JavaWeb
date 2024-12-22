package com.rh.webapplication.mapper;

import com.rh.webapplication.pojo.Emp;
import com.rh.webapplication.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {
     /**
     * 查询总记录数
     */
//    @Select("Select count(*) from emp e left join dept d on e.dept_id=d.id")
//    public Long count();

    /**
     * 分页查询
     * @param start
     * @param pageSize
     * @return
     */
//    @Select("Select e.*,e.name from emp e left join dept d on e.dept_id=d.id order by e.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> list(Integer start,Integer pageSize);

    //@Select("Select e.*,d.name deptName from emp e left join dept d on e.dept_id=d.id where e.name like '%小%' and e.gender=1 and e.entry_date between '2010-01-01' and '2020-01-01' order by e.update_time desc ")
    //public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
    public List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 新增员工信息
     * @param emp
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time) values(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);
}
