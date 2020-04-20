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

    /**
     * switch statement in java
     */
    @Test
    public void Test2() {
        // char grade = args[0].charAt(0);
        // char grade = 'C';
        char grade = 'B';

        switch (grade) {
            case 'A':
                System.out.println("Excellent!");
                break;
            case 'B':
            case 'C':
                System.out.println("Well done");
                break;
            case 'D':
                System.out.println("You passed");
            case 'F':
                System.out.println("Better try again");
                break;
            default:
                System.out.println("Invalid grade");
        }
        System.out.println("Your grade is " + grade);
    }
}