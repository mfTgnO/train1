package com.example.demo.java8lambdas.completablefuture;

import static com.example.demo.java8lambdas.completablefuture.Util.delay;
import static com.example.demo.java8lambdas.completablefuture.Util.format;

/**
 * @Package: com.example.demo.java8lambdas.completablefuture
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-20 16:05
 * @Description:
 */
public class Discount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    private static double apply(double price, Code code) {
        // Simulate a delay in the Discount service response.
        delay();
        return format(price * (100 - code.percentage) / 100);
    }

    public static String applyDiscount(Quote quote) {
        // Apply the discount code to the original price.
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }
}