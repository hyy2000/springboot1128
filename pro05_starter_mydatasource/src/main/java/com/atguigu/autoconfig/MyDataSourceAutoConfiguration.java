package com.atguigu.autoconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.properties.MyDataSourceProperties;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootConfiguration
public class MyDataSourceAutoConfiguration {
    @Resource
    private MyDataSourceProperties myDataSourceProperties;

    @Bean
    @ConditionalOnProperty(value = "spring9.jdbc.datasource.type",havingValue = "druid")
    public DataSource createDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(myDataSourceProperties.getDriverClassName());
        dataSource.setUrl(myDataSourceProperties.getUrl());
        dataSource.setUsername(myDataSourceProperties.getUsername());
        dataSource.setPassword(myDataSourceProperties.getPassword());
        return dataSource;
    }
    @Bean
    @ConditionalOnProperty(prefix = "spring9.jdbc.datasource",name = "type",havingValue = "c3p0",matchIfMissing = true)
    public DataSource createC3P0DataSource() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(myDataSourceProperties.getDriverClassName());
        dataSource.setJdbcUrl(myDataSourceProperties.getUrl());
        dataSource.setUser(myDataSourceProperties.getUsername());
        dataSource.setPassword(myDataSourceProperties.getPassword());
        return dataSource;
    }


}
