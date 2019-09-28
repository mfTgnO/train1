package com.example.demo.foundation;

import com.example.demo.enums.EnumDeleteType;
import org.junit.Test;

/**
 * @createDate: 2019-09-28 10:36
 * @description:
 */
public class EnumDemo {
    @Test
    public void test1() {
        EnumDeleteType enumDeleteType = EnumDeleteType.forType(2);
        System.out.println(enumDeleteType);
    }
}