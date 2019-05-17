package com.example.demo.java8lambdas.defaultmethods;

/**
 * @Package: com.example.demo.java8lambdas.defaultmethods
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-17 17:35
 * @Description:
 */
public class Ambiguous {
    public static void main(String[] args) {
        new C().hello();
    }

    static interface A {
        public default void hello() {
            System.out.println("Hello from A");
        }
    }

    static interface B {
        public default void hello() {
            System.out.println("Hello from B");
        }
    }

    static class C implements B, A {

        @Override
        public void hello() {
            A.super.hello();
        }
    }
}
