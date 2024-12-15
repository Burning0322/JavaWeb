package com.rh.webapplication.service;

import com.rh.webapplication.pojo.Emp;
import com.rh.webapplication.pojo.PageResult;

public interface EmpService {
    /**
     * 分页查询方法
     * @param page 页码
     * @param pageSize 每页显示的记录数
     * @return
     */
    PageResult<Emp> page(Integer page, Integer pageSize);
}
