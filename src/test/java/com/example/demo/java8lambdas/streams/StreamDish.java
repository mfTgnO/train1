package com.example.demo.java8lambdas.streams;

import com.example.demo.java8lambdas.domain.Dish;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Package: com.example.demo.java8lambdas.streams
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-29 15:52
 * @Description:
 */
public class StreamDish {
    private static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    // groupingBy
    @Test
    public void test1() {
        Map<Dish.Type, List<Dish>> dishByType = menu.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println(dishByType);
    }

    // Low Caloric Dishes Name
    @Test
    public void test2() {
        List<String> lowCaloricDishesName = menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(lowCaloricDishesName);
    }

    /*
     * To exploit a multicore architecture and execute this code in parallel, you need only change
     * stream() to parallelStream():
     * */
    @Test
    public void test3() {
        List<String> lowCaloricDishesName = menu.parallelStream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(lowCaloricDishesName);
    }

    // Traversable only once
    @Test
    public void test4() {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        // java.lang.IllegalStateException: stream has already been operated upon or closed
        s.forEach(System.out::println);
    }

    // Listing 4.1. Collections: external iteration with a for-each loop
    @Test
    public void test5() {
        List<Object> names = new ArrayList<>();
        for (Dish dish : menu) {// explicitly iterate the list of menu sequentially.
            names.add(dish.getName());// extract the name and add it to an accumulator.
        }
        System.out.println(names);
    }

    // Listing 4.2. Collections: external iteration using an iterator behind the scenes
    @Test
    public void test6() {
        List<Object> names = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {// iterating explicitly
            Dish dish = iterator.next();
            names.add(dish.getName());
        }
        System.out.println(names);
    }

    // Listing 4.3. Streams: internal iteration
    @Test
    public void test7() {
        List<String> names = menu.stream()
                .map(Dish::getName)// parameterize map with the getName method to extract the name of a dish.
                .collect(Collectors.toList());// start executing the pipeline of operations;no iteration!
        System.out.println(names);
    }

    // 4.4.1. Intermediate operations
    @Test
    public void test8() {
        List<String> collect = menu.stream()
                .filter(d -> {
                    System.out.println("filtering:" + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping:" + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test9() {
        long count = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();
        System.out.println(count);
    }

    // Filtering with a predicate
    @Test
    public void test10() {
        List<Dish> collect = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    // Filtering unique elements
    @Test
    public void test11() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    // Truncating a stream
    @Test
    public void test12() {
        List<Dish> collect = menu.stream()
                .limit(3).collect(Collectors.toList());
        System.out.println(collect);
    }

    // Skipping elements
    @Test
    public void test13() {
        List<Dish> collect = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test14() {
        List<Dish> collect = menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    // Applying a function to each element of a stream
    @Test
    public void test15() {
        List<String> collect = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test16() {
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> collect = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test17() {
        List<Integer> collect = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    // Flattening streams
    @Test
    public void test18() {
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> collect = words.stream()
                .map(w -> w.split(""))
                .distinct()
                .collect(Collectors.toList());
        for (String[] str : collect) {
            System.out.println(Arrays.toString(str));
        }
    }

    // Attempt using map and Arrays.stream
    @Test
    public void test19() {
        List<String> words = Arrays.asList("Hello", "World");
        List<Stream<String>> collect = words.stream()
                .map(w -> w.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    // Using flatMap
    @Test
    public void test20() {
        List<String> words = Arrays.asList("Hello", "World");
        List<String> collect = words.stream()
                .map(w -> w.split(""))// converts each word into an array of its individuals letter
                .flatMap(Arrays::stream)// flattens each generated stream into a single stream
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /*
     * Given a list of numbers, how would you return a list of the square of each number? For
     * example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
     * */
    @Test
    public void test21() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /*
     * Given two lists of numbers, how would you return all pairs of numbers? For example, given a
     * list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
     * simplicity, you can represent a pair as an array with two elements.
     * */
    @Test
    public void test22() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> collect = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());
        for (int[] ints : collect) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
