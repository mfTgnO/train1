package com.example.demo.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @createDate: 2019-08-26 16:28
 * @description:
 */
public class md5 {
    @Test
    public void test() {
        String str = "/v1/works/detail?nullWenle-Key-hehe";
        String md5Hex = DigestUtils.md5Hex(str);
        System.out.println(md5Hex);
    }
}
