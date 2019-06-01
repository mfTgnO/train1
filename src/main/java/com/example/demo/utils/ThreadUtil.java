package com.example.demo.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @package: com.example.demo.utils
 * @author:
 * @email:
 * @createDate: 2019-06-01 16:45
 * @description:
 */
public class ThreadUtil {
    public static final Executor EXECUTOR2 = Executors.newFixedThreadPool(100, r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

//    ThreadPoolExecutor.
}
