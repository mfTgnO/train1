package com.example.demo.thread;

public class LoopPrint implements Runnable {
    private String name;
    private Object prev;
    private Object self;

    public LoopPrint(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        LoopPrint pa = new LoopPrint("A", c, a);
        LoopPrint pb = new LoopPrint("B", a, b);
        LoopPrint pc = new LoopPrint("C", b, c);

        new Thread(pa).start();
        Thread.sleep(100);

        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
