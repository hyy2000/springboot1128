package com.atguigu.dao;

import com.atguigu.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
@Component
public interface UserMapper extends Mapper<User> {

}
