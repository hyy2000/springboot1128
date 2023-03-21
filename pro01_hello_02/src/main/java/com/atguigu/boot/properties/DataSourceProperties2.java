package com.atguigu.boot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class DataSourceProperties2 {
    @Value("${spring2.jdbc.datasource.url}")
    private String url;
    @Value("${spring2.jdbc.datasource.password}")
    private String pwd;
    @Value("${spring2.jdbc.datasource.username}")
    private String username;
    @Value("${spring2.jdbc.datasource.driver-class-name}")
    private String driverClassName;

    public DataSourceProperties2() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Override
    public String toString() {
        return "DataSourceProperties2{" +
                "url='" + url + '\'' +
                ", pwd='" + pwd + '\'' +
                ", username='" + username + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                '}';
    }
}
