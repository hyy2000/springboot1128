package com.atguigu.controller;

import com.atguigu.properties.DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private DataSourceProperties dataSourceProperties;
    @RequestMapping("/hello")
    public String hello01(){
//        return "!!!!hello springboot!!!!";
        return dataSourceProperties.toString();

    }

}
