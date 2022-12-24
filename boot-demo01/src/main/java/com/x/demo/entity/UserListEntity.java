package com.x.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class UserListEntity {
    @ExcelProperty(value = "user_id")
    private String userId;
    @ExcelProperty("username")
    private String username;
    private String name;

    public String getName() {
        return "userid:\"" +userId+ "\"";
    }

    @Override
    public String toString() {
        return "UserListEntity{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
