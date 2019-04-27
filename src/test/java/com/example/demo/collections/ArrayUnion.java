package com.example.demo.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 10:24
 * @Description:
 */
public class ArrayUnion {
    // 1. Union between two integer arrays
    @Test
    public void test1() {
        Integer[] firstArray = {0, 2, 4, 6, 8};
        Integer[] secondArray = {1, 3, 5, 7, 9};

        List<Integer> list1 = Arrays.asList(firstArray);
        List<Integer> list2 = Arrays.asList(secondArray);

        Set<Integer> set = new HashSet<>();

        set.addAll(list1);
        set.addAll(list2);

        System.out.println(set);

        // convert to array
        Integer[] union = {};
        union = set.toArray(union);

        System.out.println(Arrays.toString(union));
    }

    // 2. Union between two string arrays
    @Test
    public void test2() {
        String[] firstArray = {"A", "B", "C", "D"};
        String[] secondArray = {"D", "A", "E", "F"};

        Set<String> set = new HashSet<>();

        set.addAll(Arrays.asList(firstArray));
        set.addAll(Arrays.asList(secondArray));

        System.out.println(set);

        // convert to array
        String[] union = {};
        union = set.toArray(union);

        System.out.println(Arrays.toString(union));
    }
}
