package com.example.demo.java8lambdas.completablefuture;

import org.junit.Test;

import java.util.concurrent.Future;

import static com.example.demo.java8lambdas.completablefuture.AsyncShop.*;

/**
 * @Package: com.example.demo.java8lambdas.completablefuture
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-20 17:26
 * @Description:
 */
public class AsyncShopClient {
    /*
     * synchronous
     * */
    @Test
    public void test1() {
        AsyncShop shop = new AsyncShop("BestShop");
        long start = System.nanoTime();
        double futurePrice = shop.getPrice("myPhone");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        try {
            System.out.println("Price is " + futurePrice);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrieveTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrieveTime + " msecs");
    }

    /*
     * asynchronous
     * */
    @Test
    public void test2() {
        AsyncShop shop = new AsyncShop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("myPhone");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        try {
            System.out.println("Price is " + futurePrice.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrieveTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrieveTime + " msecs");
    }

    /*
     * asynchronous
     *
     * Listing 11.6. Propagating an error inside the CompletableFuture
     * */
    @Test
    public void test3() {
        AsyncShop shop = new AsyncShop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsyncV2("");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        try {
            System.out.println("Price is " + futurePrice.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrieveTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrieveTime + " msecs");
    }

    /*
     * Listing 11.9. Checking findPrices correctness and performance
     * */
    @Test
    public void test4() {
        long start = System.nanoTime();
        System.out.println(findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    @Test
    public void test5() {
        long start = System.nanoTime();
        System.out.println(findPricesParallel("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    @Test
    public void test6() {
        long start = System.nanoTime();
        System.out.println(findPricesCompletableFuture("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    @Test
    public void test7() {
        long start = System.nanoTime();
        System.out.println(findPricesCompletableFutureV2("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    /*
    * 11.4.2. Using the Discount service
    * */
    @Test
    public void test8() {
        long start = System.nanoTime();
        System.out.println(findPricesV2("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    @Test
    public void test9() {
        long start = System.nanoTime();
        System.out.println(findPricesV3("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }
}