package com.example.demo.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrintThreadsSequentiallyMain {
    public static void main(String[] args) {
        PrintSequenceRunnable runnable1 = new PrintSequenceRunnable(1);
        PrintSequenceRunnable runnable2 = new PrintSequenceRunnable(2);
        PrintSequenceRunnable runnable3 = new PrintSequenceRunnable(0);

        Thread t1 = new Thread(runnable1, "T1");
        Thread t2 = new Thread(runnable2, "T2");
        Thread t3 = new Thread(runnable3, "T3");

        System.out.println("T1 State:" + t1.getState());
        System.out.println("T2 State:" + t2.getState());
        System.out.println("T3 State:" + t3.getState());

        t1.start();
        t2.start();
        t3.start();

        System.out.println("T1 State:" + t1.getState());
        System.out.println("T2 State:" + t2.getState());
        System.out.println("T3 State:" + t3.getState());
    }

    @Test
    public void test1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
    }

    @Test
    public void test2() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
    }
}
