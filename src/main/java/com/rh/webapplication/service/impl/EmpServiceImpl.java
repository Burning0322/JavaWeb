package com.rh.webapplication.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rh.webapplication.mapper.EmpMapper;
import com.rh.webapplication.pojo.Emp;
import com.rh.webapplication.pojo.EmpQueryParam;
import com.rh.webapplication.pojo.PageResult;
import com.rh.webapplication.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        Long total=empMapper.count();
//
//        Integer start=(page-1)*pageSize;
//        List<Emp> rows=empMapper.list(start,pageSize);
//
//        PageResult<Emp> pageResult=new PageResult<>();
//
//        return new PageResult<Emp> (total,rows);
//    }
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
//        PageHelper.startPage(page,pageSize);
//
//        List<Emp> empList=empMapper.list(name,gender,begin,end);
//
//        Page<Emp> p =(Page<Emp>) empList;
//        return new PageResult<Emp>(p.getTotal(),p.getResult());
//    }
        @Override
        public PageResult<Emp> page(EmpQueryParam empQueryParam) {
            PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());

            List<Emp> empList=empMapper.list(empQueryParam);

            Page<Emp> p =(Page<Emp>) empList;
            return new PageResult<Emp>(p.getTotal(),p.getResult());
        }
}
