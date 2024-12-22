package com.rh.webapplication.controller;

import com.rh.webapplication.pojo.Emp;
import com.rh.webapplication.pojo.EmpQueryParam;
import com.rh.webapplication.pojo.PageResult;
import com.rh.webapplication.pojo.Result;
import com.rh.webapplication.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * 员工管理Controller
 */

@RequestMapping("/emps")
@RestController
public class EmpController {
    /**
     * 分页查询员工信息
     * @return
     */
    @Autowired
    private EmpService empService;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EmpController.class);

//    @GetMapping
//    public Result page(Integer page,Integer pageSize)
//    {
//        log.info("分页查询：{},{}",page,pageSize);
//        PageResult<Emp> pageResult=empService.page(page,pageSize);
//        return Result.success(pageResult);
//    }

//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10")Integer pageSize,
//                       String name, Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,@DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate end){
//        log.info("分页查询：{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
//        PageResult<Emp> pageResult=empService.page(page,pageSize,name,gender,begin,end);
//        return Result.success(pageResult);
//    }

    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询: {}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 保存员工信息
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Emp emp)
    {
        log.info("保存员工信息：{}",emp);
        empService.save(emp);
        return Result.success();
    }

//    /**
//     * 删除员工
//     * @return
//     */
//    @DeleteMapping
//    public Result delete(Integer[] ids)
//    {
//        log.info("删除员工：{}", Arrays.toString(ids));
//        return Result.success();
//    }

    /**
     * 删除员工 List
     * @return
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids)
    {
        log.info("删除员工：{}", ids);
        empService.delete(ids);
        return Result.success();
    }


}
