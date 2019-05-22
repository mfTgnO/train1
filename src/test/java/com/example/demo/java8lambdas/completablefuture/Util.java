package com.example.demo.java8lambdas.completablefuture;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Package: com.example.demo.java8lambdas.completablefuture
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-20 16:07
 * @Description:
 */
public class Util {
    private static final Random RANDOM = new Random();
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.CHINA));

    public static void delay() {
        int delay = 1000;
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static double format(double number) {
        synchronized (DECIMAL_FORMAT) {
            return new Double(DECIMAL_FORMAT.format(number));
        }
    }

    public static <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> futures) {
        /*return CompletableFuture.supplyAsync(() -> futures.stream()
                .map(future -> future.join())
                .collect(Collectors.toList()));*/

        CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        return allDoneFuture.thenApply(v -> futures.stream()
                .map(future -> future.join())
                .collect(Collectors.toList()));
    }

    /*
     * Listing 11.19. A method to simulate a random delay between 0.5 and 2.5 seconds
     * */
    public static void randomDelay() {
        int delay = 500 + RANDOM.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}