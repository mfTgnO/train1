package com.example.demo.thread;

import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @package: com.example.demo.thread
 * @author:
 * @email:
 * @createDate: 2019-06-15 18:20
 * @description:
 */
public class CountDownLatchDemo {
    /**
     * As stated in the definitions, CyclicBarrier allows a number of threads to wait on each other,
     * whereas CountDownLatch allows one or more threads to wait for a number of tasks to complete.
     * <p>
     * In short, CyclicBarrier maintains a count of threads whereas CountDownLatch maintains a count of tasks.
     * <p>
     * In the following code, we define a CountDownLatch with a count of two. Next, we call countDown() twice from a single thread:
     */
    @Test
    public void test1() {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        assertEquals(2, countDownLatch.getCount());

        Thread t = new Thread(() -> {
            countDownLatch.countDown();
            countDownLatch.countDown();
        });

        t.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(0, countDownLatch.getCount());
    }

    /**
     * CyclicBarrier, though, is different on this point.
     * Similar to the above example, we create a CyclicBarrier, again with a count of two and call await() on it, this time from the same thread:
     */
    @Test
    public void test2() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        Thread t = new Thread(() -> {
            try {
                cyclicBarrier.await();
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t.start();

//        assertEquals(0, cyclicBarrier.getNumberWaiting());
        assertEquals(1, cyclicBarrier.getNumberWaiting());
        assertFalse(cyclicBarrier.isBroken());
    }

    /**
     * Reusability
     * <p>
     * The second most evident difference between these two classes is reusability. To elaborate, when
     * the barrier trips in CyclicBarrier, the count resets to its original value. CountDownLatch is different because the count never resets.
     * In the given code, we define a CountDownLatch with count 7 and count it through 20 different calls:
     */
    @Test
    public void test3() {
        CountDownLatch countDownLatch = new CountDownLatch(7);
        ExecutorService es = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            es.execute(() -> {
                long prevValue = countDownLatch.getCount();
                countDownLatch.countDown();
                if (countDownLatch.getCount() != prevValue) {
                    outputScraper.add("Count Updated");
                }
            });
        }
        es.shutdown();

        assertTrue(outputScraper.size() <= 7);
    }

    @Test
    public void test4() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7);

        ExecutorService es = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            es.execute(() -> {
                try {
                    if (cyclicBarrier.getNumberWaiting() <= 0) {
                        outputScraper.add("Count Updated");
                    }
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    // error handling
                }
            });
        }
        es.shutdown();

        assertTrue(outputScraper.size() > 7);
    }
}
