package com.x.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class LogEntity {
    @ExcelProperty("日期")
    private String date;
    @ExcelProperty("用户id")
    private String userId;
    @ExcelProperty("用户名")
    private String username;
    @ExcelProperty("用户团队")
    private String team;
    @ExcelProperty("分类")
    private String type;
    @ExcelProperty("搜索关键字")
    private String keyWords;
}
