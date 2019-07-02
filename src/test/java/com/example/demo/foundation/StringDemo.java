package com.example.demo.foundation;

import org.junit.Test;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-14 15:55
 * @description:
 */
public class StringDemo {
    @Test
    public void test1() {
        String str0 = "hello";
        String str1 = "he" + new String("llo");

        // 内存地址
        // false
        System.err.println(str0 == str1);

        // same sequence of characters
        // true
        System.err.println(str0.equals(str1));
    }

    @Test
    public void test2() {
        String str0 = "aaa";
        String str1 = "aaa";

        String str2 = new String("bbb");
        String str3 = new String("bbb");

        // true
        System.err.println(str0 == str1);
        // true
        System.err.println(str0.equals(str1));

        // false
        System.err.println(str2 == str3);
        // true
        System.err.println(str2.equals(str3));
    }

    @Test
    public void test3() {
        String str = "hello";
        int h = str.indexOf("h");
        System.out.println(h);

        h = str.indexOf("e");
        System.out.println(h);

        h = str.indexOf("l");
        System.out.println(h);

        h = str.indexOf("o");
        System.out.println(h);

        h = str.indexOf("he");
        System.out.println(h);
    }
}