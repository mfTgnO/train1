package com.example.demo.java8lambdas.streams;

import com.example.demo.java8lambdas.domain.Dish;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * @Package: com.example.demo.java8lambdas.streams
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-29 15:52
 * @Description:
 */
public class StreamDish {
    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    /**
     * 分组
     */
    @Test
    public void test1() {
        Map<Dish.Type, List<Dish>> dishByType = menu.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println(dishByType);
    }

    /**
     * calories低于400的name，排序
     */
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

    /**
     * 4.4.1. Intermediate operations
     * 内部执行流程
     */
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

    /**
     * Applying a function to each element of a stream
     * 获取name
     */
    @Test
    public void test15() {
        List<String> collect = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 获取字符串长度
     */
    @Test
    public void test16() {
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> collect = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 获取字符串长度
     */
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

    /**
     * 将每个生成的流扩展为单个流
     * Using flatMap
     */
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

    /**
     * Given a list of numbers, how would you return a list of the square of each number? For
     * example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
     * <p>
     * 求平方数
     */
    @Test
    public void test21() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * Given two lists of numbers, how would you return all pairs of numbers? For example, given a
     * list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
     * simplicity, you can represent a pair as an array with two elements.
     * 组合
     */
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

    /*
     * How would you extend the previous example to return only pairs whose sum is divisible by 3?
     * For example, (2, 4) and (3, 3) are valid.
     * */
    @Test
    public void test23() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> collect = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                ).collect(Collectors.toList());
        for (int[] ints : collect) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * Finding and matching
     * Checking to see if a predicate matches at least one element
     */
    @Test
    public void test24() {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
    }

    /**
     * Checking to see if a predicate matches all elements
     */
    @Test
    public void test25() {
        boolean allMatch = menu.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println("allMatch:" + allMatch);
    }

    /**
     * The opposite of allMatch is noneMatch. It ensures that no elements in the stream match the
     * given predicate. For example, you could rewrite the previous example as follows using
     * noneMatch:
     */
    @Test
    public void test26() {
        boolean noneMatch = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
        System.out.println("noneMatch:" + noneMatch);
    }

    /*
     * NOTE
     *
     * These three operations, anyMatch, allMatch, and noneMatch, make use of what we call
     * short-circuiting, a stream version of the familiar Java short-circuiting && and || operators.
     * */

    /*
     * Finding an element
     * */
    @Test
    public void test27() {
        Optional<Dish> optionalDish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        if (optionalDish.isPresent()) {
            Dish dish = optionalDish.get();
            System.out.println(dish);
        }
    }

    /*
     * Optional in a nutshell
     * */
    @Test
    public void test28() {
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));
    }

    /*
     * Finding the first element
     * */
    @Test
    public void test29() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst();
        if (firstSquareDivisibleByThree.isPresent()) {
            Integer integer = firstSquareDivisibleByThree.get();
            System.out.println(integer);
        }
    }

    /**
     * 5.4. Reducing
     * 5.4.1. Summing the elements
     */
    @Test
    public void test30() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;
        for (Integer someNumber : someNumbers) {
            sum += someNumber;
        }
        System.out.println(sum);
    }

    /**
     * 求和
     */
    @Test
    public void test31() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = someNumbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    /**
     * 求乘积
     */
    @Test
    public void test32() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer product = someNumbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(product);
    }

    /**
     * method reference
     * <p>
     * You can make this code more concise by using a method reference. In Java 8 the Integer class
     * now comes with a static sum method to add two numbers, which is just what you want instead
     * of repeatedly writing out the same code as lambda:
     */
    @Test
    public void test33() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = someNumbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    /*
     * No initial value
     *
     * There’s also an overloaded variant of reduce that doesn’t take an initial value, but it returns an
     * Optional object:
     * Why does it return an Optional<Integer>? Consider the case when the stream contains no
     * elements. The reduce operation can’t return a sum because it doesn’t have an initial value. This
     * is why the result is wrapped in an Optional object to indicate that the sum may be absent. Now
     * see what else you can do with reduce.
     * */
    @Test
    public void test34() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = someNumbers.stream()
                .reduce((a, b) -> a + b);
        if (sum.isPresent()) {
            Integer integer = sum.get();
            System.out.println(integer);
        }
    }

    /**
     * 最大值
     * 5.4.2. Maximum and minimum
     */
    @Test
    public void test35() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> max = someNumbers.stream()
                .reduce(Integer::max);
        if (max.isPresent()) {
            Integer integer = max.get();
            System.out.println(integer);
        }
    }

    /**
     * 最小值
     */
    @Test
    public void test36() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> min = someNumbers.stream()
                .reduce(Integer::min);
        if (min.isPresent()) {
            Integer integer = min.get();
            System.out.println(integer);
        }
    }

    /**
     * 最小值
     */
    @Test
    public void test37() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> min = someNumbers.stream()
                .reduce((x, y) -> x < y ? x : y);
        if (min.isPresent()) {
            Integer integer = min.get();
            System.out.println(integer);
        }
    }

    /**
     * 最大值
     */
    @Test
    public void test38() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> max = someNumbers.stream()
                .reduce((x, y) -> x < y ? y : x);
        if (max.isPresent()) {
            Integer integer = max.get();
            System.out.println(integer);
        }
    }

    /**
     * 计算元素个数
     * How would you count the number of dishes in a stream using the map and reduce methods?
     */
    @Test
    public void test39() {
        Integer reduce = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }

    /**
     * 计算元素个数
     */
    @Test
    public void test40() {
        long count = menu.stream().count();
        System.out.println(count);
    }

    /**
     * 元素求和
     */
    @Test
    public void test41() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = someNumbers.parallelStream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    /**
     * How to Convert List to Map in Java
     */
    @Test
    public void test42() {
        Map<String, Dish> collect = menu.stream()
                .collect(toMap(Dish::getName, dish -> dish));
        Iterator<String> iterator = collect.keySet().iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next + "\t\t" + collect.get(next));
        }
    }
}
