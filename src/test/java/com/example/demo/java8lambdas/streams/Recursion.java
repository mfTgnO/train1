package com.example.demo.java8lambdas.streams;

import org.junit.Test;

import java.util.stream.LongStream;

/**
 * @Package: com.example.demo.java8lambdas.streams
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-25 00:15
 * @Description:
 */
public class Recursion {
    @Test
    public void test1() {
        System.out.println(factorialIterative(5));
    }

    @Test
    public void test2() {
        System.out.println(factorialRecursive(5));
    }

    @Test
    public void test3() {
        System.out.println(factorialStreams(5));
    }

    @Test
    public void test4() {
        System.out.println(factorialTailRecursive(5));
    }

    public int factorialIterative(int n) {
        int r = 1;
        for (int i = 1; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    public long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }

    public long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long a, long b) -> a * b);
    }

    public long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    public long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n - 1);
    }
}