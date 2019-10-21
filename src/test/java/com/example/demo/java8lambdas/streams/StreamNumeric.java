package com.example.demo.java8lambdas.streams;

import com.example.demo.java8lambdas.domain.Dish;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntSupplier;
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
    /**
     * calories求和
     * You saw earlier that you could use the reduce method to calculate the sum of the elements of a
     * stream. For example, you can calculate the number of calories in the menu as follows:
     */
    @Test
    public void test1() {
        Integer sum = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    /**
     * Mapping to a numeric stream
     */
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
        try {
            // /home/rnj/workspace/ws1/spring_in_action_5th_edition/sia
            String currentDir = Paths.get("").toAbsolutePath().toString();
            uniqueWords = Files.lines(Paths.get(currentDir + "/src/main/resources/lambdasinaction/chap5/data.txt"), Charset.defaultCharset())
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println("There are " + uniqueWords + " unique words in data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test13() {
        Path currentDir = Paths.get("");
        System.out.println(currentDir.toAbsolutePath());
    }

    /*
     * 5.7.4. Streams from functions: creating infinite streams!
     * Iterate
     * */
    @Test
    public void test14() {
        Stream.iterate(0, n -> n + 2)
                .limit(20)
                .forEach(System.out::println);
    }

    /*
     * Quiz 5.4: Fibonacci tuples series
     * */
    @Test
    public void test15() {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    }

    /*
     * Note that if you just wanted to print the normal Fibonacci series,
     * you could use a map to extract only the first element of each tuple:
     * */
    @Test
    public void test16() {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    /*
     * Generate
     * */
    @Test
    public void test17() {
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void test18() {
        IntStream twos = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        });
        twos.limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void test19() {
        IntStream twos = IntStream.generate(() -> 2);
        twos.limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void test20() {
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib)
                .limit(10)
                .forEach(System.out::println);
    }
}
