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

    @Test
    public void test2() {
        String alphanumeric = RandomStringUtils.randomAlphanumeric(18);
        System.out.println(alphanumeric);
    }
}
