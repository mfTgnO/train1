package com.example.demo.foundation;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-14 12:09
 * @description:
 */
public class ClassLoaderDemoV2 {
    static {
        System.out.println("static block");
    }

    {
        System.out.println("block");
    }

    public static void main(String[] args) {
        new ClassLoaderDemoV2();
//        System.out.println("main");
    }

    public static void test() {
        System.out.println("test");
    }
}
