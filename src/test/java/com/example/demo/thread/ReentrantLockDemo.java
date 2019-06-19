package com.example.demo.thread;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @package: com.example.demo.thread
 * @author:
 * @email:
 * @createDate: 2019-06-19 16:01
 * @description:
 */
public class ReentrantLockDemo {
    public class Service {
        // 默认非公平锁
//        ReentrantLock lock = new ReentrantLock(true);
        // 公平锁
        ReentrantLock lock = new ReentrantLock();

        public Service() {
        }

        void getThreadName() {
            System.out.println(Thread.currentThread().getName() + " 已经被锁定");
        }
    }

    public class ThreadClass extends Thread {
        private Service service;

        public ThreadClass(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 抢到了锁");

            service.lock.lock();
            try {
                service.getThreadName();
            } finally {
                service.lock.unlock();
            }
        }
    }

    @Test
    public void test() {
        Service service = new Service();
        ThreadClass tcArray[] = new ThreadClass[10];

        for (int i = 0; i < 10; i++) {
            tcArray[i] = new ThreadClass(service);
            tcArray[i].start();
        }
    }
}
