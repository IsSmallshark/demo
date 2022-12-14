package com.x.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.x.demo.entity.UserEntity;
import com.x.demo.service.mapper.UserMapper;
import com.x.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity getUser(Integer id) {
        return userMapper.selectById(2);
    }
}
