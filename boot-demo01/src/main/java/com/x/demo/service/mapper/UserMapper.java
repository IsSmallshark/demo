package com.x.demo.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.x.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    UserEntity getUserById(Integer id);

}
