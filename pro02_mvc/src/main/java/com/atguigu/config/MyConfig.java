package com.atguigu.config;

import com.atguigu.interceptor.MyInterCeptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootConfiguration
public class MyConfig implements WebMvcConfigurer {
    @Autowired
    private MyInterCeptor myInterCeptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterCeptor)
                .addPathPatterns("/user/**");
    }
}
