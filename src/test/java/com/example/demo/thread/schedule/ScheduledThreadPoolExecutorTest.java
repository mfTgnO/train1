package com.example.demo.thread.schedule;

import java.util.concurrent.*;

/**
 * @package: com.example.demo.thread.schedule
 * @author:
 * @email:
 * @createDate: 2019-06-11 15:24
 * @description: ScheduledThreadPoolExecutor belongs to java.util.concurrent package. While creating object of ScheduledThreadPoolExecutor, we need to pass core pool Size. ScheduledThreadPoolExecutor executes and schedules task. We create its object as following.
 * <p>
 * ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(corePoolSize);
 * <p>
 * where corePoolSize is the pool size i.e number of threads that can be executed by ScheduledThreadPoolExecutor at a time.
 * 1. execute method of ScheduledThreadPoolExecutor will execute only Runnable task.
 * <p>
 * stpe.execute(new ScheduledThreadPoolExecutorTest().new RunnableThread());
 * <p>
 * 2. schedule method of ScheduledThreadPoolExecutor can accept Callable and Runnable task both. It returns ScheduledFuture instance.
 * <p>
 * ScheduledFuture<Integer> sf =
 * stpe.schedule(new ScheduledThreadPoolExecutorTest().new CallableThread(), 2, TimeUnit.SECONDS);
 * <p>
 * Find the complete example.
 */
public class ScheduledThreadPoolExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int corePoolSize = 2;

        //creates ScheduledThreadPoolExecutor object with number of thread 2
        ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(corePoolSize);

        //starts runnable thread
        stpe.execute(new ScheduledThreadPoolExecutorTest().new RunnableThread());

        //starts callable thread that will start after 2 seconds
        ScheduledFuture<Integer> sf = stpe.schedule(new ScheduledThreadPoolExecutorTest().new CallableThread(), 2,
                TimeUnit.SECONDS);

        //gets value returned by callable thread
        int res = sf.get();
        System.out.println("value returned by Callable Thread." + res);

        //returns active thread
        int activeCnt = stpe.getActiveCount();
        System.out.println("activeCnt:" + activeCnt);

        //stops all the threads in ScheduledThreadPoolExecutor
        stpe.shutdownNow();
        System.out.println(stpe.isShutdown());
    }

    class RunnableThread implements Runnable {

        @Override
        public void run() {
            int cnt = 0;
            for (; cnt < 5; cnt++) {
                System.out.println("run:" + cnt);
            }
        }
    }

    class CallableThread implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int cnt = 0;
            for (; cnt < 5; cnt++) {
                System.out.println("call:" + cnt);
            }
            return cnt;
        }
    }
}
