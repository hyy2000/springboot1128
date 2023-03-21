package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> list = new ArrayList<>();
        list.add(new User("加缪","123456",19,"男"));
        list.add(new User("毛姆","456",19,"男"));
        list.add(new User("萨特","123",19,"男"));
        list.add(new User("test","123456",19,"男"));
        return list;
    }
}
