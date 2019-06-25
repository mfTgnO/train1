package com.example.demo.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @package: com.example.demo.dynamicproxy.jdk
 * @author:
 * @email:
 * @createDate: 2019-06-25 11:36
 * @description:
 */
public class JDKDynamicProxyDemo {
    public static void main(String[] args) {
        Service service = new MyService();
        Service proxyInstance = (Service) Proxy.newProxyInstance(JDKDynamicProxyDemo.class.getClassLoader(), new Class[]{Service.class}, new MyHandler(service));
        proxyInstance.print();

        // 使用反射打印一下类名试试
        System.out.println(proxyInstance.getClass().getName());
    }
}
