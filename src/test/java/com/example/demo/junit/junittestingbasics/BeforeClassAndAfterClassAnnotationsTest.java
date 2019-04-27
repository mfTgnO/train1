package com.example.demo.junit.junittestingbasics;

import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @Package: com.example.demo.junit.junittestingbasics
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 15:58
 * @Description:
 */
@RunWith(JUnit4.class)
@Slf4j
public class BeforeClassAndAfterClassAnnotationsTest {
    @BeforeClass
    public static void setup() {
        log.info("startup - creating DB connection");
    }

    @AfterClass
    public static void tearDown() {
        log.info("closing DB connection");
    }

    @Test
    public void simpleTest() {
        log.info("simple test");
    }

    @Test
    public void anotherSimpleTest() {
        log.info("another simple test");
    }
}
