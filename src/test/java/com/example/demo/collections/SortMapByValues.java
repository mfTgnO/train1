package com.example.demo.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @package: com.example.demo.collections
 * @author:
 * @email:
 * @createDate: 2019-06-10 13:52
 * @description:
 */
public class SortMapByValues {
    public static Map<String, Integer> unSortedMap = new HashMap<>();

    @Before
    public void getUnSortedMap() {
        unSortedMap.put("alex", 1);
        unSortedMap.put("david", 2);
        unSortedMap.put("elle", 3);
        unSortedMap.put("charles", 4);
        unSortedMap.put("brian", 5);
    }

    @Test
    public void sortByValueJava8Stream() {
        System.out.println("Unsorted Map : " + unSortedMap);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Sorted Map   : " + sortedMap);

        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
    }
}
