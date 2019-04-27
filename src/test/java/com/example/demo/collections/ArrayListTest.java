package com.example.demo.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 14:27
 * @Description:
 */
public class ArrayListTest {
    // Create ArrayList
    @Test
    public void test1() {
        //Empty arraylist
        List<String> names = new ArrayList<>();
        System.out.println(names);

        //Arraylist initialized with another collection
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(numbers);
    }

    // Add and remove elements
    @Test
    public void test2() {
        //Create arraylist
        List<String> names = new ArrayList<>();

        names.add("a");
        names.add("b");
        names.set(1, "c");
        names.remove(0);

        System.out.println(names);
    }
}
