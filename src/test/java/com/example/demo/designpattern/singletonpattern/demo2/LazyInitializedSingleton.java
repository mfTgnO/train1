package com.example.demo.designpattern.singletonpattern.demo2;

/**
 * @package: com.example.demo.designpattern.singletonpattern.demo2
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:13
 * @description:
 */
public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {
    }

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
