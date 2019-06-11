package com.example.demo.thread.communication;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.example.demo.thread.communication
 * @author:
 * @email:
 * @createDate: 2019-06-11 14:26
 * @description: In java, threads can communicate to each other in many ways. One of the way is using wait and notify.
 * wait() and notify() belongs to Object class in java. In our example we have a producer thread and
 * second is consumer thread. Producer is adding element in a list and this value is being fetched by
 * consumer. Here communication means producer will not add next element until consumer will fetch that.
 * To achieve it producer will add the element in the list and will call wait() method. It stops executing
 * and releases the lock on calling object. Now consumer starts executing and removes the value from the list.
 * It notifies the producer and then goes into waiting state releasing the lock on calling object. Find the example.
 * 在 java 中, 线程可以通过多种方式相互通信。其中一种方法是使用等待和通知。wait()和notify() 属于 java 中的 Object 类。
 * 在我们的示例中, 我们有一个生成线程, 第二个是使用者线程。生成器正在列表中添加元素, 并且使用者正在获取此值。在这里,
 * 通信意味着生成器不会添加下一个元素, 直到使用者将获取该元素。为了实现它, 生成器将在列表中添加元素, 并将调用wait()方法。
 * 它停止执行并释放调用对象的锁。现在使用者开始执行并从列表中删除值。它通知生成器, 然后进入等待状态, 释放调用对象上的锁。找到示例。
 */
public class WaitNotifyTest {
    private static Object lock = new Object();
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        new Producer().start();
        new Consumer().start();
    }

    static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (list.size() == 0) {
                        System.out.println("Producer added A");
                        list.add("A");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock.notify();
                    }
                }
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (list.size() == 1) {
                        System.out.println("Consumer consumes A");
                        list.remove(0);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
