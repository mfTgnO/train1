package com.example.demo.designpattern.singletonpattern.demo2;

import java.io.Serializable;

/**
 * @package: com.example.demo.designpattern.singletonpattern.demo2
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:18
 * @description:
 */
public class SerializedSingleton implements Serializable {
    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton() {
    }

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }
}
