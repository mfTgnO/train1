package com.example.demo.collections.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
    /**
     * Java array contains – ArrayList contains example
     * https://howtodoinjava.com/array/array-arraylist-contains-example/
     * <p>
     * To check if an ArrayList contains an element, use ArrayList.contains(element) method.
     * contains(element) method does not take null argument, and will throw NullPointerException is null is passed in the method.
     */
    @Test
    public void test1() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("banana", "guava", "apple", "cheeku"));
        System.out.println(list.contains("apple"));
        System.out.println(list.indexOf("apple"));

        System.out.println(list.contains("lion"));
        System.out.println(list.indexOf("lion"));
    }

    /**
     * Check if Java 8 Stream contains an element
     * <p>
     * Since Java 8, streams also hold elements and you might want to test if stream contains element or not.
     * Use stream.anyMatch() method which returns whether any elements of this stream match the provided predicate.
     * In predicate simply check the equality to current element in stream and argument element which needs to be find.
     */
    @Test
    public void test2() {
        String[] fruits = new String[]{"banana", "guava", "apple", "cheeku"};
        boolean apple = Arrays.asList(fruits)
                .stream()
                .anyMatch(x -> x.equalsIgnoreCase("apple"));
        System.out.println(apple);

        boolean lion = Arrays.asList(fruits)
                .stream()
                .anyMatch(x -> x.equalsIgnoreCase("lion"));
        System.out.println(lion);

        boolean apple_ = Arrays.stream(fruits)
                .anyMatch(x -> x.equalsIgnoreCase("apple"));
        System.out.println(apple_);
    }
}
