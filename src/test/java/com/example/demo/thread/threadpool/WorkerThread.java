package com.example.demo.thread.threadpool;

/**
 * @package: com.example.demo.thread.threadpool
 * @author:
 * @email:
 * @createDate: 2019-06-10 16:38
 * @description:
 */
public class WorkerThread implements Runnable {
    private String command;

    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    @Override
    public String toString() {
        return this.command;
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
