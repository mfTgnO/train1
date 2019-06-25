package com.example.demo.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @package: com.example.demo.dynamicproxy.jdk
 * @author:
 * @email:
 * @createDate: 2019-06-25 11:34
 * @description:
 */
public class MyHandler implements InvocationHandler {
    private Service service;

    public MyHandler(Service service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this is before!");
        Object result = method.invoke(service, args);
        System.out.println("this is after!");
        return result;
    }
}
