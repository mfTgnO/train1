package com.example.demo.thread.threadfactory;

import java.util.concurrent.ThreadFactory;

/**
 * @package: com.example.demo.thread.threadfactory
 * @author:
 * @email:
 * @createDate: 2019-06-11 13:44
 * @description:
 */
public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
