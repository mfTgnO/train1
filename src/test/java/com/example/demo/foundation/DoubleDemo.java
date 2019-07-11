package com.example.demo.foundation;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-07-10 17:18
 * @description:
 */
public class DoubleDemo {
    /**
     * double保留一位小数
     */
    @Test
    public void test1() {
        double num = 1.234d;

        Double truncatedDouble = BigDecimal.valueOf(num)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
        System.out.println(truncatedDouble);
    }
}
