package com.example.demo.java8lambdas.methodreferences;

import com.example.demo.java8lambdas.domain.Apple;
import com.example.demo.java8lambdas.lambdaexpressions.FilteringApples;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Package: com.example.demo.java8lambdas.methodreferences
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-28 15:59
 * @Description:
 */
public class MethodReferences {
    // lambda expression
    @Test
    public void test1() {
        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println(str);
    }

    // method reference
    @Test
    public void test2() {
        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort(String::compareToIgnoreCase);
        System.out.println(str);
    }

    @Test
    public void test3() {
        String str = "2019";
        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        Integer apply = stringToInteger.apply(str);
        System.out.println(apply);
    }

    @Test
    public void test4() {
        String str = "2019";
        Function<String, Integer> stringToInteger = Integer::parseInt;
        Integer apply = stringToInteger.apply(str);
        System.out.println(apply);
    }

    @Test
    public void test5() {
        List<String> l = Arrays.asList("a", "b", "c", "d");
        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        boolean test = contains.test(l, "a");
        System.out.println(test);
    }

    @Test
    public void test6() {
        List<String> l = Arrays.asList("a", "b", "c", "d");
        BiPredicate<List<String>, String> contains = List::contains;
        boolean test = contains.test(l, "a");
        System.out.println(test);
    }

    // Constructor references
    @Test
    public void test7() {
        Supplier<Apple> supplier = Apple::new;
        Apple apple = supplier.get();
        System.out.println(apple);
    }

    @Test
    public void test8() {
        Supplier<Apple> supplier = () -> new Apple();
        Apple apple = supplier.get();
        System.out.println(apple);
    }

    @Test
    public void test9() {
//        Function<Integer, Apple> function = Apple::new;
    }

    @Test
    public void test10() {
//        Function<Integer, Apple> function = (weight) -> new Apple(weight);
    }

    @Test
    public void test11() {
        FilteringApples.inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(FilteringApples.inventory);
    }

    @Test
    public void test12() {
        FilteringApples.inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple s1, Apple s2) {
                return Integer.compare(s1.getWeight(), s2.getWeight());
            }
        });
    }

    @Test
    public void test13() {
        FilteringApples.inventory.sort(Comparator.comparingInt(Apple::getWeight));
        System.out.println(FilteringApples.inventory);
    }

    @Test
    public void test14() {
        FilteringApples.inventory.sort(Comparator.comparing((apple -> apple.getWeight())));
        System.out.println(FilteringApples.inventory);
    }

    @Test
    public void test15() {
        FilteringApples.inventory.sort(Comparator.comparing((Apple::getWeight)));
        System.out.println(FilteringApples.inventory);
    }

    @Test
    public void test16() {
        FilteringApples.inventory.sort(Comparator.comparing((Apple::getColor))
                .reversed());
        System.out.println(FilteringApples.inventory);
    }

    // Chaining Comparators
    @Test
    public void test17() {
        FilteringApples.inventory.sort(Comparator.comparing(Apple::getColor)
                .thenComparing(Apple::getWeight));
        System.out.println(FilteringApples.inventory);
    }

    @Test
    public void test18() {
        FilteringApples.inventory.sort(Comparator.comparing(Apple::getColor)
                .reversed()
                .thenComparing(Apple::getWeight));
        System.out.println(FilteringApples.inventory);
    }

    //  Composing Functions
    @Test
    public void test19() {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        Integer result = h.apply(1);
        System.out.println(result);
    }

    @Test
    public void test20() {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.compose(g);
        Integer result = h.apply(1);
        System.out.println(result);
    }
}
