package com.example.demo.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @package: com.example.demo.thread.threadpool
 * @author:
 * @email:
 * @createDate: 2019-06-10 16:41
 * @description:
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable t = new WorkerThread("" + i);
            executor.execute(t);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("Finished all threads");
    }
}
