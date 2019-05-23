package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    public void contextLoads() {
    }

    @Test
    public void hikariConnectionPoolIsConfigured() {
        String name = dataSource.getClass().getName();
        System.out.println("data source name :" + name);
    }
}