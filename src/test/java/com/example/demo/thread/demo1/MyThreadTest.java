package com.example.demo.thread.demo1;

import org.junit.Test;

/**
 * @package: com.example.demo.thread.demo1
 * @author:
 * @email:
 * @createDate: 2019-06-11 09:35
 * @description:
 */
public class MyThreadTest {
    @Test
    public void test1() {
        MyThread t = new MyThread();
        t.run();
    }

    @Test
    public void test2() {
        Thread t = new Thread(() -> System.out.println("MyThread running"));
        t.run();
    }

    @Test
    public void test3() {
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();
    }
}
