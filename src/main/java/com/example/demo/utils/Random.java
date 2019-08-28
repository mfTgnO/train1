package com.example.demo.utils;

/**
 * @createDate: 2019-08-23 15:48
 * @description:
 */
public class Random {
    public static void randomlyRunLong() {
        java.util.Random rand = new java.util.Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        if (randomNum == 3) {
            sleep();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
