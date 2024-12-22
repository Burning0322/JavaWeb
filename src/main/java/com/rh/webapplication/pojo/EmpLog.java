package com.rh.webapplication.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class EmpLog {
    private Integer id; //ID
    private LocalDateTime operateTime; //操作时间
    private String info; //详细信息

    public EmpLog() {
    }

    public EmpLog(Integer id, LocalDateTime operateTime, String info) {
        this.id = id;
        this.operateTime = operateTime;
        this.info = info;
    }
}
