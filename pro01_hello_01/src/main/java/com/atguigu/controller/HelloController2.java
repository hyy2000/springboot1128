package com.atguigu.controller;

import com.atguigu.properties.DataSourceProperties2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableConfigurationProperties(DataSourceProperties2.class)
public class HelloController2 {
    @Resource
    private DataSourceProperties2 dataSourceProperties2;
    @RequestMapping("/h02")
    public String h02(){
        return dataSourceProperties2.toString();
    }
}
