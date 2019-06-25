package com.example.demo.dynamicproxy.jdk;

/**
 * @package: com.example.demo.dynamicproxy.jdk
 * @author:
 * @email:
 * @createDate: 2019-06-25 11:34
 * @description:
 */
public class MyService implements Service {
    @Override
    public void print() {
        System.out.println("this is print");
    }
}
