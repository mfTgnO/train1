package com.example.demo.foundation;

import org.junit.Test;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-25 16:23
 * @description:
 */
public class BinaryDemo {
    @Test
    public void test1() {
        //二进制,1.7版本前面加上0b表示二进制,b大写小写都可以
        System.out.println(0b100);
        //八进制
        System.out.println(074);
        //十进制
        System.out.println(100);
        //十六进制,10到15分别用a到f表示,大小写都可以
        System.out.println(0x3c);
        // 0b1010101  052  0x52
    }
}
