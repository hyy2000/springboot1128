package com.atguigu;

import com.atguigu.dao.UserMapper;
import com.atguigu.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void findAll(){
        List<User> users = userMapper.selectAll();
        users.forEach(System.out::println);
    }
}
