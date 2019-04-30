package com.example.demo.java8lambdas.streams;

import com.example.demo.java8lambdas.domain.Dish;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.example.demo.java8lambdas.streams.StreamDish.menu;

/**
 * @Package: com.example.demo.java8lambdas.streams
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-30 15:40
 * @Description:
 */
public class StreamNumeric {
    /*
     * You saw earlier that you could use the reduce method to calculate the sum of the elements of a
     * stream. For example, you can calculate the number of calories in the menu as follows:
     * */
    @Test
    public void test1() {
        Integer sum = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    /*
     * Mapping to a numeric stream
     * */
    @Test
    public void test2() {
        int sum = menu.stream()// return a Stream<Dish>
                .mapToInt(Dish::getCalories)// return an IntStream
                .sum();
        System.out.println(sum);
    }

    /*
     * Converting back to a stream of objects
     * */
    @Test
    public void test3() {
        IntStream intStream = menu.stream()
                .mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed();
    }

    /*
     * For example, you can find the maximal element of an IntStream by calling the max method,
     * which returns an OptionalInt:
     * */
    @Test
    public void test4() {
        OptionalInt max = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        if (max.isPresent()) {
            int asInt = max.getAsInt();
            System.out.println(asInt);
        }

        // You can now process the OptionalInt explicitly to define a default value if there’s no maximum:
        int i = max.orElse(1);
        System.out.println(i);
    }

    /*
     * 5.6.2. Numeric ranges
     *
     * A common use case when dealing with numbers is working with ranges of numeric values. For
     * example, suppose you’d like to generate all numbers between 1 and 100. Java 8 introduces two
     * static methods available on IntStream and LongStream to help generate such ranges: range and
     * rangeClosed. Both methods take the starting value of the range as the first parameter and the
     * end value of the range as the second parameter. But range is exclusive, whereas rangeClosed is
     * inclusive. Let’s look at an example:
     * */
    @Test
    public void test5() {
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());
    }

    @Test
    public void test6() {
        IntStream evenNumbers = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());
    }

    /*
     * Generating tuples
     * */
    @Test
    public void test7() {
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        // Running the code
        pythagoreanTriples.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

    /*
     * Can you do better?
     *
     * The current solution isn’t optimal because you calculate the square root twice. One possible way
     * to make your code more compact is to generate all triples of the form (a*a, b*b, a*a+b*b) and
     * then filter the ones that match your criteria:
     * */
    @Test
    public void test8() {
        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0));
        pythagoreanTriples2.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

    /*
     * 5.7.1. Streams from values
     *
     * You can create a stream with explicit values by using the static method Stream.of, which can
     * take any number of parameters. For example, in the following code you create a stream of
     * strings directly using Stream.of. You then convert the strings to uppercase before printing them
     * one by one:
     * */
    @Test
    public void test9() {
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase)
                .forEach(System.out::println);
    }

    /*
     * You can get an empty stream using the empty method as follows:
     * */
    @Test
    public void test10() {
        Stream<Object> emptyStream = Stream.empty();
    }

    /*
     * 5.7.2. Streams from arrays
     * */
    @Test
    public void test11() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
    }

    /*
     * 5.7.3. Streams from files
     * */
    @Test
    public void test12() {
        long uniqueWords = 0;
        Files.lines(Paths.get("/src/main/resources/lambdasinaction/chap5/data.txt"), Charset.defaultCharset())
    }
}
