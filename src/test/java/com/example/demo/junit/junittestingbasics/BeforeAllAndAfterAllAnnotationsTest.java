package com.example.demo.junit.junittestingbasics;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @Package: com.example.demo.junit.junittestingbasics
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 16:08
 * @Description:
 */
@Slf4j
public class BeforeAllAndAfterAllAnnotationsTest {
    @BeforeAll
    public static void setup() {
        log.info("startup - creating DB connection");
    }

    @AfterAll
    public static void tearDown() {
        log.info("closing DB connection");
    }

    @Test
    public void whenCheckingListSize_thenSizeEqualsToInit() {
        log.info("executing test");
    }

    @Test
    public void whenCheckingListSizeAgain_thenSizeEqualsToInit() {
        log.info("executing another test");
    }
}
