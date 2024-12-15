package com.rh.webapplication.service.impl;

import com.rh.web.mapper.EmpMapper;
import com.rh.web.pojo.Emp;
import com.rh.web.pojo.PageResult;
import com.rh.webapplication.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    /**
     *
     * @param page 页码
     * @param pageSize 每页显示的记录数
     * @return
     */

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        Long total=empMapper.count();

        Integer start=(page-1)*pageSize;
        List<Emp> rows=empMapper.list(start,pageSize);

        PageResult<Emp> pageResult=new PageResult<>();

        return new PageResult<Emp> (total,rows);
    }
}
