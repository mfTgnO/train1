package com.example.demo.thread;

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
}
