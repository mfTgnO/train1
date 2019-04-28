package com.example.demo.java8lambdas.lambdaexpressions;

import com.example.demo.java8lambdas.domain.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Package: com.example.demo.java8lambdas.lambdaexpressions
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 17:39
 * @Description:
 */
public class FilteringApples {
    public static List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
            new Apple(155, "green"),
            new Apple(120, "red"));

    /*@Before
    public void init() {
        inventory.addAll(Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")));
    }*/

    @Test
    public void filterGreenApples() {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        System.out.println(result);
    }

    @Test
    public void filterHeavyApples() {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        System.out.println(result);
    }

    @Test
    public void filterApples() {
        filter(FilteringApples::isGreenApple);
        filter(FilteringApples::isHeavyApple);
        filter((Apple a) -> "green".equals(a.getColor()));
        filter((Apple a) -> a.getWeight() > 150);
        filter((Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
    }

    private static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    private static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    private void filter(Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        System.out.println(result);
    }
}
