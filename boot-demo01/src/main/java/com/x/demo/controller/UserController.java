package com.x.demo.controller;

import com.x.demo.entity.UserEntity;
import com.x.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/getUser")
    public UserEntity getUser(Integer id) {
        return userService.getUser(id);
    }
}
