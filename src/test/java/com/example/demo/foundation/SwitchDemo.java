package com.example.demo.foundation;

import org.junit.Test;

/**
 * Switch Statement in Java
 * https://www.geeksforgeeks.org/switch-statement-in-java/
 */
public class SwitchDemo {
    @Test
    public void test1() {
        int like = 2;
        switch (like) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
            default:
                System.out.println("none");
        }
        System.out.println("end");
    }
}