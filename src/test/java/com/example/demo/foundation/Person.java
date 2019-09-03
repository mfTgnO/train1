package com.example.demo.foundation;

public class Person {
    static {
        System.out.println("执行Person静态代码块");
    }

    {
        System.out.println("执行Person构造代码块");
    }

    public Person() {
        System.out.println("执行Person无参构造方法");
    }

    public Person(String name) {
        System.out.println("执行Person构造方法" + name);
    }
}
