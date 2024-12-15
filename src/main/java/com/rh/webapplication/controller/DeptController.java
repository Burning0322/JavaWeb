package com.rh.webapplication.controller;

import com.rh.web.pojo.Dept;
import com.rh.web.pojo.Result;
import com.rh.web.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
        List<Dept> deptList = deptService.findAll();
        System.out.println("Dept List: " + deptList);
        return Result.success(deptList);
    }

//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam("id") Integer deptId) {
//        deptService.delete(id);
//        System.out.println("delete id"+deptId);
//        return Result.success();
//    }

    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable("id") Integer deptId) {
        System.out.println("delete id: " + deptId);
        return Result.success();
    }

    //用RequestBody可以将数据封装成对象后返回Json格式
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept)
    {
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result getId(@PathVariable("id") Integer id)
    {
        Dept dept=deptService.getId(id);
        return Result.success(dept);
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept)
    {
        deptService.update(dept);
        return Result.success();
    }
}