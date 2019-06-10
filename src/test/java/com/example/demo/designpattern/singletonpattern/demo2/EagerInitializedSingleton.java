package com.example.demo.designpattern.singletonpattern.demo2;

/**
 * @package: com.example.demo.designpattern.singletonpattern.demo2
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:12
 * @description:
 */
public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton() {
    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}
