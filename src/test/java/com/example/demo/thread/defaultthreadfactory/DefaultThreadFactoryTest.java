package com.example.demo.thread.defaultthreadfactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @package: com.example.demo.thread.defaultthreadfactory
 * @author:
 * @email:
 * @createDate: 2019-06-11 13:55
 * @description:
 */
public class DefaultThreadFactoryTest {
    public static void main(String[] args) {
        ThreadFactory tf = Executors.defaultThreadFactory();
        Thread t = tf.newThread(new SampleThread());
        t.start();

        System.out.println(t.getName());
    }

    static class SampleThread implements Runnable {

        @Override
        public void run() {
            int cnt = 0;
            for (; cnt < 5; cnt++) {
                System.out.println("run:" + cnt);
            }
        }
    }
}
