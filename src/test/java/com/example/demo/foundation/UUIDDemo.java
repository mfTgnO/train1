package com.example.demo.foundation;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.UUID;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-24 17:31
 * @description:
 */
public class UUIDDemo {
    @Test
    public void test1() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }

    /**
     * (a-z, A-Z, 0-9)
     */
    @Test
    public void test2() {
        String alphanumeric = RandomStringUtils.randomAlphanumeric(16);
        System.out.println(alphanumeric);
    }

    /**
     * (0-9)
     */
    @Test
    public void test3() {
        String alphanumeric = RandomStringUtils.randomNumeric(18);
        System.out.println(alphanumeric);
    }
}
