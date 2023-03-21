package com.atguigu.controller;

import com.atguigu.entity.User;
import com.atguigu.service.UserService;
import com.atguigu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public Result findAll(){
        List<User> userList = userService.findAll();
        return Result.ok(userList);
    }
}
