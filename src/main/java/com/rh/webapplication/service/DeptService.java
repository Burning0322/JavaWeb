package com.rh.webapplication.service;

import com.rh.webapplication.pojo.Dept;
import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept getId(Integer id);

    void update(Dept dept);
}
