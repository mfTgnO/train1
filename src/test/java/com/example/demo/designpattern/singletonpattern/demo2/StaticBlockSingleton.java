package com.example.demo.designpattern.singletonpattern.demo2;

/**
 * @package: com.example.demo.designpattern.singletonpattern.demo2
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:13
 * @description:
 */
public class StaticBlockSingleton {
    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() {
    }

    //static block initialization for exception handling
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
