package com.example.demo.dynamicproxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @package: com.example.demo.dynamicproxy.cglib
 * @author:
 * @email:
 * @createDate: 2019-06-25 11:40
 * @description:
 */
public class CglibIntercepter implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("this is before!");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("this is after!");
        return result;
    }
}

