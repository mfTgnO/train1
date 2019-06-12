package com.example.demo.collections.bit;

import org.junit.Test;

/**
 * @package: com.example.demo.collections.bit
 * @author:
 * @email:
 * @createDate: 2019-06-12 14:12
 * @description:
 */
public class BitDemo {
    @Test
    public void test() {
        long num = 1L << 41;

        // 2199023255552
        System.out.println(num);

        long time = 1000L * 3600 * 24 * 365;

        long year = 2199023255552L / time;
        System.out.println(year);
    }
}
