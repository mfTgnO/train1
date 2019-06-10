package com.example.demo.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @package: com.example.demo.collections
 * @author:
 * @email:
 * @createDate: 2019-06-10 13:41
 * @description: By default, all key-value pairs in TreeMap are sorted in their natural order. So all you need to do is add all unsorted key-value pairs in TreeMap.
 */
public class SortMapByKey {
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
    public void sortByKeyUsingTreeMap() {
        System.out.println("Unsorted Map : " + unSortedMap);

        Map<String, Integer> sortedMap = new TreeMap<String, Integer>(unSortedMap);

        System.out.println("Sorted Map   : " + sortedMap);

        Map<String, Integer> reverseSortedMap = new TreeMap<String, Integer>(Collections.reverseOrder());
        reverseSortedMap.putAll(unSortedMap);

        System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
    }

    @Test
    public void sortByKeyJava8Stream() {
        System.out.println("Unsorted Map : " + unSortedMap);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Sorted Map   : " + sortedMap);

        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
    }
}
