package com.example.demo.foundation;


public class SubClass extends SuperClass {
    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类构造代码块");
    }

    public SubClass() {
        System.out.println("子类构造函数");
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        System.out.println("-----------------");
        SubClass subClass1 = new SubClass();
    }
}
