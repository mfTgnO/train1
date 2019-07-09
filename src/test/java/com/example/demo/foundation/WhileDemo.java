package com.example.demo.foundation;

import org.junit.Test;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-07-09 15:19
 * @description:
 */
public class WhileDemo {
    /**
     * break
     */
    @Test
    public void test1() {
        int num = 10;
        while (true) {
            num--;
            if (num == 5) {
                System.out.println("break: " + num);
                break;
            }
            System.out.println("continue" + num);
        }
    }
}
