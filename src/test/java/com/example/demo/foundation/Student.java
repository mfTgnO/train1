package com.example.demo.foundation;

public class Student extends Person {
    static {
        System.out.println("执行Student静态代码块");
    }

    {
        System.out.println("执行Student构造代码块");
    }

    public Student(String name) {
        super(name);
        System.out.println("执行Student构造方法" + name);
    }

    public Student() {
        super();
        System.out.println("执行Student无参构造方法");
    }
}
