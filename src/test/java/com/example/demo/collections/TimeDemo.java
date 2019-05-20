package com.example.demo.collections;

import org.junit.Test;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-19 20:47
 * @Description:
 */
public class TimeDemo {
    @Test
    public void test1() {
        long l = System.nanoTime();
        System.out.println(l);
    }

    @Test
    public void test2() {
        String str = "窗含西岭千秋雪";
        String str2 = "hello";

        System.out.println(str.length());
        System.out.println(str2.length());
    }

    @Test
    public void test3() {
        String str = "hello";
        /*for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }*/
        long l = str.charAt(0) * 1;
        long l2 = str.charAt(1) * 1;
        System.out.println(l);
        System.out.println(l2);

        System.out.println(str.charAt(0));
    }
}