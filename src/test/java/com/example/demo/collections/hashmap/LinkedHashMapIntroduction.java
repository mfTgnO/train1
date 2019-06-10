package com.example.demo.collections.hashmap;

import org.junit.Test;

import java.util.*;

/**
 * @package: com.example.demo.collections.hashmap
 * @author:
 * @email:
 * @createDate: 2019-06-10 16:03
 * @description: LinkedHashMap in Java is used to store key-value pairs very similar to HashMap class.
 * Difference is that LinkedHashMap maintains the order of elements inserted into it while HashMap is unordered.
 * <p>
 * It stores key-value pairs similar to HashMap.
 * It contains only unique keys. Duplicate keys are not allowed.
 * It may have one null key and multiple null values.
 * It maintains the order of K,V pairs inserted to it by adding elements to internally managed doubly-linked list.
 */
public class LinkedHashMapIntroduction {
    /*
     * 2.1. Insertion ordered LinkedHashMap
     * By default, LinkedHashMap is insertion ordered. It maintains the order of elements
     * when they were added to it. While iterating over LinkedHashMap, we get the KV pairs in exact order they were added.
     * */
    @Test
    public void test() {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(1, "A");
        linkedHashMap.put(2, "B");
        linkedHashMap.put(3, "C");
        linkedHashMap.put(4, "D");
        linkedHashMap.put(5, "E");

        linkedHashMap.forEach((key, value) ->
                System.out.println("Key:" + key + ", Value:" + value)
        );
    }

    /*
     * 2.2. Access ordered LinkedHashMap
     *
     * In access ordered map, keys are sorted on the basis of access order last
     * time they were accessed using any method of LinkedHashMap. Invoking the put, putIfAbsent,
     * get, getOrDefault, compute, computeIfAbsent, computeIfPresent, or merge methods results in an access to the corresponding entry.
     *
     * The keys are sorted from least recently accessed used to most recently accessed and build a LRU cache.
     * To create access order map, LinkedHashMap has a special constructor argument.
     * When set to true, LinkedHashMap maintains the access order.
     * */
    @Test
    public void test2() {
        //3rd parameter set access order
        LinkedHashMap<Integer, String> pairs = new LinkedHashMap<>(2, 0.75f, true);

        pairs.put(1, "A");
        pairs.put(2, "B");
        pairs.put(3, "C");
        pairs.put(4, "D");

        //Access 1st pair
        String v = pairs.getOrDefault(2, "oops");
        System.out.println(v);

        pairs.forEach((key, value) -> {
            System.out.println("Key:" + key + ", Value:" + value);
        });

        v = pairs.get(3);    //get method
        System.out.println(v);

        v = pairs.getOrDefault(5, "oops");  //getOrDefault method
        System.out.println(v);

        //Iteration example
        Iterator<Integer> iterator = pairs.keySet().iterator();

        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println("Key: " + key + ", Value: " + pairs.get(key));
        }

        //Remove example
        pairs.remove(3);
        System.out.println(pairs);

        System.out.println(pairs.containsKey(1));    //containsKey method

        System.out.println(pairs.containsValue("B"));    //containsValue method
    }

    /*
     * 7. Concurrency in LinkedHashMap
     * Both HashMap and LinkedHashMap are not thread-safe which means we can not directly use them in a
     * multi-threaded application for consistent results. We should synchronize them explicitely by using Collections.synchronizedMap(Map map) method.
     * */
    @Test
    public void test3() {
        Map<Integer, String> synchronizedMap = Collections.synchronizedMap(new LinkedHashMap<Integer, String>());
        Map<Integer, Integer> numbers = Collections.synchronizedMap(new HashMap<>());
    }
}
