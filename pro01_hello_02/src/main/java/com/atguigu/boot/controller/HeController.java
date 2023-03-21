package com.atguigu.boot.controller;


import com.atguigu.boot.properties.DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@EnableConfigurationProperties(DataSourceProperties.class)
public class HeController {
    @Resource
    private DataSourceProperties dataSourceProperties;
    @RequestMapping("/he01")
    public String hello01(){
        return dataSourceProperties.toString();
    }
}
