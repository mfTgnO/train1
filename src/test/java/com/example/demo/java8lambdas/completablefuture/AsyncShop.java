package com.example.demo.java8lambdas.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

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

    private static final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("MyFavoriteShop2"),
//            new Shop("MyFavoriteShop3"),
//            new Shop("MyFavoriteShop4"),
//            new Shop("MyFavoriteShop5"),
//            new Shop("MyFavoriteShop6"),
            new Shop("BuyItAll"));

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
    }

    public Future<Double> getPriceAsyncV2(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                // If the price calculation completed normally,complete the Future with the price.
                futurePrice.complete(price);
            } catch (Exception ex) {
                // Otherwise,complete it exceptionally with the Exception that caused the failure.
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        return futurePrice;
    }

    /*
     * Creating a CompletableFuture with the supplyAsync factory method
     * */
    public Future<Double> getPriceAsyncV3(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
//        if (true) throw new RuntimeException("product not available");
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPriceV2(product)))
                .collect(Collectors.toList());
    }

    /*
     * 11.3.1. Parallelizing requests using a parallel Stream
     * */
    public static List<String> findPricesParallel(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPriceV2(product)))
                .collect(Collectors.toList());
    }

    /*
     * Listing 11.11. Implementing the findPrices method with CompletableFutures
     * */
    public static List<String> findPricesCompletableFuture(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPriceV2(product)))
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    /*
     * Listing 11.12. A custom Executor fitting our best-price-finder application
     * */
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    private static final Executor EXECUTOR2 = Executors.newFixedThreadPool(Math.min(shops.size(), 100), r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    public static List<String> findPricesCompletableFutureV2(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPriceV2(product), EXECUTOR2))
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    /*
     * 11.4.2. Using the Discount service
     *
     * The desired result is obtained by pipelining three map operations on the stream of shops:
     * The first operation transforms each shop into a String that encodes the price and discount code of the
     * requested product for that shop.
     * The second operation parses those Strings, converting each of them in a Quote object.
     * Finally, the third one contacts the remote Discount service that will calculate the final discounted
     * price and return another String containing the name of the shop with that price.
     * */
    public static List<String> findPricesV2(String product) {
        return shops.stream()
                // Retrieve th nondiscounted price from each shop.
                .map(shop -> shop.getPrice(product))
                // Transform the Strings returned by the shops in Quote objects.
                .map(Quote::parse)
                // Contact the Discount service to apply the discount on each Quote.
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    /*
     * Listing 11.16. Implementing the findPrices method with
     * */
    public static List<String> findPricesV3(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        // Asynchronously retrieve the nondiscounted price from each shop.
                        () -> shop.getPrice(product), EXECUTOR2))
                // Transform String returned by a shop into a Quote object when it becomes available.
                .map(future -> future.thenApply(Quote::parse))
                // Compose the resulting Future with another asynchronous task,applying the discount code.
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), EXECUTOR2)))
                .collect(Collectors.toList());
        return priceFutures.stream()
                // Wait for all the Futures in the stream to be completed and extract their respective results.
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
