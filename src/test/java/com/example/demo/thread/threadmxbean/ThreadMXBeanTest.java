package com.example.demo.thread.threadmxbean;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @package: com.example.demo.thread.threadmxbean
 * @author:
 * @email:
 * @createDate: 2019-06-11 16:11
 * @description:
 */
public class ThreadMXBeanTest {
    class UserThread extends Thread {
        @Override
        public void run() {
            ThreadMXBean thMxB = ManagementFactory.getThreadMXBean();
            System.out.println(("Current thread count:" + thMxB.getThreadCount()));
            //gets current thread cpu time.
            System.out.println("CurrentThreadCpuTime: " + thMxB.getCurrentThreadCpuTime());
            //gets curent thread user time.
            System.out.println("CurrentThreadUserTime:" + thMxB.getCurrentThreadUserTime());
            //gets Demon thread count
            System.out.println("DaemonThreadCount:" + thMxB.getDaemonThreadCount());
            //gets peaak thread count
            System.out.println("PeakThreadCount:" + thMxB.getPeakThreadCount());
            //gets thread count
            System.out.println("ThreadCount:" + thMxB.getThreadCount());
        }
    }

    public static void main(String[] a) {
        Thread th = new ThreadMXBeanTest().new UserThread();
        Runtime.getRuntime().addShutdownHook(th);
    }
}
