package com.atguigu.service.impl;

import com.atguigu.dao.UserMapper;
import com.atguigu.entity.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;


    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        List<User> userList = (List<User>) redisTemplate.boundValueOps("userList").get();
        if (userList == null){
            System.out.println("执行sql");
            userList = userMapper.selectAll();
            redisTemplate.boundValueOps("userList").set(userList);
        }
        else {
            System.out.println("redis");
        }

        return userList;
    }
}
