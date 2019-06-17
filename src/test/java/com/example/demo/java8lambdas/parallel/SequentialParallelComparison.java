package com.example.demo.java8lambdas.parallel;

import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @package: com.example.demo.java8lambdas.parallel
 * @author:
 * @email:
 * @createDate: 2019-06-17 17:45
 * @description: Java 8 Streams - Sequential vs Parallel streams
 * https://www.logicbig.com/tutorials/core-java-tutorial/java-util-stream/sequential-vs-parallel.html
 */
public class SequentialParallelComparison {
    @Test
    public void test() {
        String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        System.out.println("-------\nRunning sequential\n-------");
        run(Arrays.stream(strings).sequential());
        System.out.println("-------\nRunning parallel\n-------");
        run(Arrays.stream(strings).parallel());
    }

    public static void run(Stream<String> stream) {
        stream.forEach(s -> {
            System.out.println(LocalTime.now() + " - value: " + s + " - thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
