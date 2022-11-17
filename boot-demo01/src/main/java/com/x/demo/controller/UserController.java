package com.x.demo.controller;

import com.x.demo.entity.UserEntity;
import com.x.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUser")
    public UserEntity getUser(Integer id) {

        return userService.getUser(id);
    }
}
