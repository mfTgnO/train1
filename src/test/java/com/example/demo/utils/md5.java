package com.example.demo.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @createDate: 2019-08-26 16:28
 * @description:
 */
public class md5 {
//    private static final String str = "hello";
    private static final String str = "qebsjkls";

    /**
     * md5Hex
     */
    @Test
    public void test1() {
        String md5Hex = DigestUtils.md5Hex(str);
        System.out.println(md5Hex);
    }

    @Test
    public void test2() {
        String md5Hex = DigestUtils.sha1Hex(str);
        System.out.println(md5Hex);
    }

    @Test
    public void test3() {
        String md5Hex = DigestUtils.sha256Hex(str);
        System.out.println(md5Hex);
    }
}
