package com.example.demo.java8lambdas.completablefuture;

import java.util.Random;

import static com.example.demo.java8lambdas.completablefuture.Util.delay;
import static com.example.demo.java8lambdas.completablefuture.Util.format;

/**
 * @Package: com.example.demo.java8lambdas.completablefuture
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-20 16:16
 * @Description:
 */
public class Shop {
    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(1000);
    }

    public Shop(String name, Random random) {
        this.name = name;
        this.random = random;
    }

    public String getName() {
        return name;
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return name + ":" + price + ":" + code;
    }

    public double getPriceV2(String product) {
        double price = calculatePrice(product);
        return price;
    }

    public double calculatePrice(String product) {
        delay();
        return format(random.nextDouble() * product.charAt(0) * product.charAt(1));
    }
}
