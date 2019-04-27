package com.example.demo.junit.junittestingbasics;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Package: com.example.demo.junit.junittestingbasics
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 16:01
 * @Description:
 */
@Slf4j
public class BeforeEachAndAfterEachAnnotationsTest {
    private List<String> list;

    @BeforeEach
    protected void init() {
        log.info("startup");
        list = new ArrayList<>(Arrays.asList("test1", "test2"));
    }

    @AfterEach
    protected void finalize() {
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
