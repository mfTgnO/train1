package com.example.demo.java8lambdas.completablefuture;

import org.junit.Test;

import java.util.concurrent.Future;

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
}