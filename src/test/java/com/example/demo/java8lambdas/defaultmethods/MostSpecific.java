package com.example.demo.java8lambdas.defaultmethods;

/**
 * @Package: com.example.demo.java8lambdas.defaultmethods
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-17 17:42
 * @Description:
 */
public class MostSpecific {
    public static void main(String[] args) {
        new C().hello();
        new E().hello();
        new G().hello();
    }

    static interface A {
        public default void hello() {
            System.out.println("Hello from A");
        }
    }

    static interface B extends A {
        public default void hello() {
            System.out.println("Hello from B");
        }
    }

    static class C implements B, A {

    }

    static class D implements A {
    }

    static class E extends D implements B, A {
    }

    static class F implements B, A {
        public void hello() {
            System.out.println("Hello from F");
        }
    }

    static class G extends F implements B, A {
    }
}
