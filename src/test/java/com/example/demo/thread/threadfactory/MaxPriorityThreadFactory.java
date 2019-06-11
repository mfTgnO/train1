package com.example.demo.thread.threadfactory;

import java.util.concurrent.ThreadFactory;

/**
 * @package: com.example.demo.thread.threadfactory
 * @author:
 * @email:
 * @createDate: 2019-06-11 13:45
 * @description:
 */
public class MaxPriorityThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(Thread.MAX_PRIORITY);
        return t;
    }
}
