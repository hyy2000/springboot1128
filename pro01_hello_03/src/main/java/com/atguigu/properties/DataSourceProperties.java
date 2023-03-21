package com.atguigu.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataSourceProperties {
    @Value("${dev.jdbc.datasource.url}")
    private String url;
    @Value("${dev.jdbc.datasource.password}")
    private String pwd;
    @Value("${dev.jdbc.datasource.username}")
    private String uname;
    @Value("${dev.jdbc.datasource.driver-class-name}")
    private String driverClassName;

    @Override
    public String toString() {
        return "DataSourceProperties{" +
                "url='" + url + '\'' +
                ", pwd='" + pwd + '\'' +
                ", uname='" + uname + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                '}';
    }
}
