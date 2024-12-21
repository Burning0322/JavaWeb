package com.rh.webapplication.service;

import com.rh.webapplication.pojo.Emp;
import com.rh.webapplication.pojo.EmpQueryParam;
import com.rh.webapplication.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface EmpService {
//    /**
//     * 分页查询方法
//     * @param page 页码
//     * @param pageSize 每页显示的记录数
//     * @return
//     */
    //PageResult<Emp> page(Integer page, Integer pageSize,String name, Integer gender, LocalDate begin,LocalDate end);
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);
}
