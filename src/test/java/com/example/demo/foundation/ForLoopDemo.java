package com.example.demo.foundation;

import org.junit.Test;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-19 16:45
 * @description:
 */
public class ForLoopDemo {
    @Test
    public void test() {
        int i = 0;
        for (; ; ) {
            if (i > 10) {
                return;
            }
            i++;
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        int i = 0;
        for (; ; ) {
            if (i == 5) {
                continue;
            }
            i++;
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println(i + " continue");
                continue;
            }
            System.out.println(i);
        }
    }
}
