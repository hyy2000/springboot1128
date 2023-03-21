package com.atguigu.controller;

import com.atguigu.properties.DataSourceProperties;
import com.atguigu.properties.DataSourceProperties2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProController {
    @Resource
    private DataSourceProperties dataSourceProperties;

    @Resource
    private DataSourceProperties2 dataSourceProperties2;
    @RequestMapping("/hello")
    public String hello(){
        return dataSourceProperties.toString();
    }
    @RequestMapping("/hello02")
    public String hello02(){
        return dataSourceProperties2.toString();
    }


}
