package com.example.demo.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @package: com.example.demo.thread.cyclicbarrier
 * @author:
 * @email:
 * @createDate: 2019-06-15 18:46
 * @description:
 */
public class CyclicBarrierCountExample {
    private int count;

    public CyclicBarrierCountExample(int count) {
        this.count = count;
    }

    public boolean callTwiceInSameThread() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        Thread t = new Thread(() -> {
            try {
                cyclicBarrier.await();
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t.start();
        return cyclicBarrier.isBroken();
    }

    public static void main(String[] args) {
        CyclicBarrierCountExample ex = new CyclicBarrierCountExample(7);
        System.out.println("Count : " + ex.callTwiceInSameThread());
    }
}
