package com.example.demo.thread.cache;

import java.util.concurrent.*;

/**
 * @package: com.example.demo.thread.cache
 * @author:
 * @email:
 * @createDate: 2019-06-11 16:00
 * @description:
 */
public class NewCachedThreadPoolTest {
    public static void main(String... args) throws InterruptedException, ExecutionException {
        //creates cached thread pool
        ExecutorService exService = Executors.newCachedThreadPool();
        // runnable thread start to execute.
        exService.execute(new NewCachedThreadPoolTest().new RunnableThread());
        //callable thread starts to execute
        Future<Integer> future = exService.submit(new NewCachedThreadPoolTest().new CallableThread());
        //gets value of callable thread
        int val = future.get();
        System.out.println(val);
        //checks for thread termination
        boolean isTerminated = exService.isTerminated();
        System.out.println(isTerminated);
        // waits for termination for 30 seconds only
        exService.awaitTermination(30, TimeUnit.SECONDS);
        exService.shutdownNow();
    }

    //Callable thread
    class CallableThread implements Callable<Integer> {
        @Override
        public Integer call() {
            int cnt = 0;
            for (; cnt < 5; cnt++) {
                System.out.println("call:" + cnt);
            }
            return cnt;
        }
    }

    //Runnable thread
    class RunnableThread implements Runnable {
        @Override
        public void run() {
            int cnt = 0;
            for (; cnt < 5; cnt++) {
                System.out.println("run:" + cnt);
            }
        }
    }
}
