package com.example.demo.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @package: com.example.demo.utils
 * @author:
 * @email:
 * @createDate: 2019-06-01 16:45
 * @description:
 */
public class Thread {
    public static final Executor EXECUTOR2 = Executors.newFixedThreadPool(100, r -> {
        java.lang.Thread t = new java.lang.Thread(r);
        t.setDaemon(true);
        return t;
    });

//    ThreadPoolExecutor.
}
