package com.example.demo.thread.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @package: com.example.demo.thread.countdownlatch
 * @author:
 * @email:
 * @createDate: 2019-06-17 11:37
 * @description:
 */
public class BrokenWorker implements Runnable{
    private final List<String> outputScraper;
    private final CountDownLatch countDownLatch;

    BrokenWorker(final List<String> outputScraper, final CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        if (true) {
            throw new RuntimeException("Oh dear");
        }
        countDownLatch.countDown();
        outputScraper.add("Counted down");
    }
}
