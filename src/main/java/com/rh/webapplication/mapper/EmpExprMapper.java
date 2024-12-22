package com.rh.webapplication.mapper;

import com.rh.webapplication.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工工作经历
 */
@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工工作经历
     * @param exprList
     */
    void insertBatch(List<EmpExpr> exprList);

    /**
     * 根据员工id删除工作经历
     * @param empIds
     */
    void deleteByEmpIds(List<Integer> empIds);
}
