package com.example.demo.foundation;

import org.junit.Test;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-14 11:42
 * @description:
 */
public class ClassLoaderDemo {
    public ClassLoaderDemo() {
        System.out.println("parent");
    }

    {
        System.out.println("parent code block");
    }

    static {
        System.out.println("parent static code block");
    }

    class ClassLoaderDemoChildren extends ClassLoaderDemo {
        public ClassLoaderDemoChildren() {
            System.out.println("children");
        }

        {
            System.out.println("children code block");
        }
    }

    static {
        System.out.println("children static code block");
    }

    /*public static void main(String[] args) {
//        new ClassLoaderDemo().new ClassLoaderDemoChildren();
        new ClassLoaderDemoChildren();
    }*/

    @Test
    public void test() {
        new ClassLoaderDemoChildren();
    }
}
