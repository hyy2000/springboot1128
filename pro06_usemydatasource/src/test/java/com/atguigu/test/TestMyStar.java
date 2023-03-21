package com.atguigu.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class TestMyStar {
    @Autowired
    private DataSource dataSource;
    @Test
    public void TestDataSource() throws SQLException {
        System.out.println("dataSource = " + dataSource);
        Class<? extends DataSource> a = dataSource.getClass();
        System.out.println(a);
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }
}
