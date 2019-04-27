package com.example.demo.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 10:47
 * @Description:
 */
public class ArrayIntersection {
    // 1. Intersection between two integer arrays
    @Test
    public void test1() {
        Integer[] firstArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] secondArray = {1, 3, 5, 7, 9};

        Set<Integer> set = new HashSet<>();

        set.addAll(Arrays.asList(firstArray));
        set.retainAll(Arrays.asList(secondArray));

        System.out.println(set);

        // convert to array
        Integer[] intersection = {};
        intersection = set.toArray(intersection);

        System.out.println(Arrays.toString(intersection));
    }

    // 2. Intersection between two string arrays
    @Test
    public void test2() {
        String[] firstArray = {"A", "B", "C", "D"};
        String[] secondArray = {"D", "A", "E", "F"};

        Set<String> set = new HashSet<>();

        set.addAll(Arrays.asList(firstArray));
        set.retainAll(Arrays.asList(secondArray));

        System.out.println(set);

        // convert to array
        String[] intersection = {};
        intersection = set.toArray(intersection);

        System.out.println(Arrays.toString(intersection));
    }
}
