package com.example.demo.designpattern.singletonpattern;

/**
 * @package: com.example.demo.designpattern.singletonpattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 17:56
 * @description:
 */
public class SingleObject {
    private static SingleObject singleObject = new SingleObject();

    public SingleObject() {
    }

    public static SingleObject getSingleObject() {
        return singleObject;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}
