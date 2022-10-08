package com.x.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_test")
public class UserEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;
}
