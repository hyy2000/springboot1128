package com.yiyuan.nginx_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String Hello(HttpServletRequest request){
        return "hello"+request.getLocalPort();
    }
}
