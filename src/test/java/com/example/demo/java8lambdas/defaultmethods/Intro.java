package com.example.demo.java8lambdas.defaultmethods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Package: com.example.demo.java8lambdas.defaultmethods
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-17 17:46
 * @Description:
 */
public class Intro {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
