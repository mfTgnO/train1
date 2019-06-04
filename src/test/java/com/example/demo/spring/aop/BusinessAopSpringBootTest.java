package com.example.demo.spring.aop;

import com.example.demo.spring.aop.business.Business1;
import com.example.demo.spring.aop.business.Business2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Implementing AOP With Spring Boot and AspectJ
 * https://dzone.com/articles/implementing-aop-with-spring-boot-and-aspectj
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BusinessAopSpringBootTest {
    @Autowired
    private Business1 business1;
    @Autowired
    private Business2 business2;

    /*@Autowired
    public BusinessAopSpringBootTest(Business1 business1, Business2 business2) {
        this.business1 = business1;
        this.business2 = business2;
    }*/

    public BusinessAopSpringBootTest() {
    }

    @Test
    public void invokeAOPStuff() {
        log.info(business1.calculateSomething());
        log.info(business2.calculateSomething());
    }
}