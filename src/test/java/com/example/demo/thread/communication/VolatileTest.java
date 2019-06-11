package com.example.demo.thread.communication;

/**
 * @package: com.example.demo.thread.communication
 * @author:
 * @email:
 * @createDate: 2019-06-11 14:15
 * @description:
 *
 * In java, volatile is thread safe variable. All the threads watch the most up-to-date value of the
 * volatile variable automatically. Because of its visibility feature, volatile variable can be used
 * for thread communication. Volatile variable is simple to use. Volatile keyword can be used as a flag
 * for decision making. It can also be used for read write lock .
 *
 * Use of Volatile
 * Find the example how to use a volatile variable in java program. We have two threads that are
 * communicating each other using volatile variable. Here volatile has been used as flag.
 * VolatileTest.java
 *
 * 在 java 中, Volatile是线程安全变量。所有线程都会自动监视可变变量的最新值。由于其可见性, 可变变量可用于线程通信。
 * Volatile使用起来很简单。可变关键字可用作决策的标志。它还可用于读写锁。
 *
 * Volatile的使用
 * 查找如何在 java 程序中使用Volatile的示例。我们有两个线程正在使用Volatile进行通信。这里的波动被用作旗帜。
 */
public class VolatileTest {
    private static volatile boolean val = true;

    public static void main(String[] args) {
        new VolatileTest().new First().start();
        new VolatileTest().new Second().start();
    }

    class First extends Thread {

        @Override
        public void run() {
            while (true) {
                if (val) {
                    System.out.println("Thread one is working.");
                    val = false;
                }
            }
        }
    }

    class Second extends Thread {

        @Override
        public void run() {
            while (true) {
                if (!val) {
                    System.out.println("Thread two is working.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    val = true;
                }
            }
        }
    }
}
