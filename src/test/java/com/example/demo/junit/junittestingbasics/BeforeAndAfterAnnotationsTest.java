package com.example.demo.junit.junittestingbasics;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @Package: com.example.demo.junit.junittestingbasics
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 15:54
 * @Description: Methods annotated with the @Before annotation are executed before each test. This is useful when we want to execute some common code before running a test.
 */
@RunWith(JUnit4.class)
@Slf4j
public class BeforeAndAfterAnnotationsTest {
    private List<String> list;

    @Before
    public void init() {
        log.info("startup");
        list = new ArrayList<>(Arrays.asList("test1", "test2"));
    }

    @After
    public void finalize() {
        log.info("finalize");
        list.clear();
    }

    @Test
    public void whenCheckingListSize_thenSizeEqualsToInit() {
        log.info("executing test");
        assertEquals(2, list.size());

        list.add("another test");
    }

    @Test
    public void whenCheckingListSizeAgain_thenSizeEqualsToInit() {
        log.info("executing another test");
        assertEquals(2, list.size());

        list.add("yet another test");
    }
}
