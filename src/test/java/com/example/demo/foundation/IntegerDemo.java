package com.example.demo.foundation;

import org.junit.Test;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-28 11:04
 * @description:
 */
public class IntegerDemo {
    @Test
    public void test1() {
        int times = 1 << 12;
        System.out.println(times);
    }

    @Test
    public void test2() {
        int result = 15 / 10 + 1;
        System.out.println(result);
    }
}
