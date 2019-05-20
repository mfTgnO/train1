package com.example.demo.java8lambdas.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static com.example.demo.java8lambdas.completablefuture.Util.delay;
import static com.example.demo.java8lambdas.completablefuture.Util.format;

/**
 * @Package: com.example.demo.java8lambdas.completablefuture
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-20 16:30
 * @Description:
 */
public class AsyncShop {
    private final String name;
    private final Random random;

    public AsyncShop(String name) {
        this.name = name;
        this.random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public Future<Double> getPriceAsync(String product) {
        // Create the CompletableFuture that will contain the result of the computation.
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                // Execute the computation asynchronously in a different Thread.
                double price = calculatePrice(product);
                // Set the value returned by the long computation on the Future when it becomes available.
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();
        // Return the Future without waiting for the computation of the result it contains to be completed.
        return futurePrice;
//        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
//        if (true) throw new RuntimeException("product not available");
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }
}
