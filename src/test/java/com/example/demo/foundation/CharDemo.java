package com.example.demo.foundation;

import org.junit.Test;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-25 16:26
 * @description:
 */
public class CharDemo {
    @Test
    public void test1() {
        // 输出char类型：a
        System.out.println('a');
        // 输出int类型：97
        System.out.println((int) 'a');
        // 输出int类型：98
        System.out.println('a' + 1);
        // 输出char类型：b
        System.out.println((char) (100));
    }

    @Test
    public void test2() {
        //输出：helloa1 任何数据用+与字符串连接最后都会产生新的字符串
        System.out.println("hello" + 'a' + 1);

        //输出: 98 hello
        System.out.println('a' + 1 + "hello");
    }
}
