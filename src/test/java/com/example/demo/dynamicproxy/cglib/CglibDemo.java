package com.example.demo.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @package: com.example.demo.dynamicproxy.cglib
 * @author:
 * @email:
 * @createDate: 2019-06-25 11:41
 * @description:
 */
public class CglibDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyService.class);
        enhancer.setCallback(new CglibIntercepter());
        MyService service = (MyService) enhancer.create();
        service.print();
    }
}

