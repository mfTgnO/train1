package com.example.demo.utils;

import java.util.Random;

/**
 * @createDate: 2019-08-23 15:48
 * @description:
 */
public class RandomUtil {
    public static void randomlyRunLong() {
        Random rand = new Random();
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
