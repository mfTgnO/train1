package com.example.demo.thread.threadfactory;

/**
 * @package: com.example.demo.thread.threadfactory
 * @author:
 * @email:
 * @createDate: 2019-06-11 13:46
 * @description: https://www.concretepage.com/java/java-threadfactory-example
 */
public class ThreadFactoryDemo {
    public static void main(String[] args) {
        DaemonThreadFactory daemontf = new DaemonThreadFactory();
        MaxPriorityThreadFactory mptf = new MaxPriorityThreadFactory();

        Runnable r = new SimpleTask("High Priority");
        mptf.newThread(r).start();

        r = new SimpleTask("Low Priority");
        daemontf.newThread(r).start();
    }

    static class SimpleTask implements Runnable {
        String s = null;

        public SimpleTask(String s) {
            this.s = s;
        }

        @Override
        public void run() {
            System.out.println(s + " Simple task done.");
        }
    }
}
