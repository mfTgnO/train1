package com.example.demo.collections.map;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @package: com.example.demo.collections.hashmap
 * @author:
 * @email:
 * @createDate: 2019-06-10 15:08
 * @description:
 */
public class SynchronizeHashMap {
    /*
     * 1. Synchronize HashMap – ConcurrentHashMap
     * */
    @Test
    public void test1() {
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put(1, "A");
        concurrentHashMap.put(2, "B");
        concurrentHashMap.put(3, "C");
        concurrentHashMap.put(4, "D");
        concurrentHashMap.put(5, "E");

        String value = concurrentHashMap.get(1);
        System.out.println(value);

        Iterator<Integer> itr = concurrentHashMap.keySet().iterator();
        while (itr.hasNext()) {
            Integer k = itr.next();
            String v = concurrentHashMap.get(k);
            System.out.println(k + "===" + v);
        }
    }

    /*
     * 2. Synchronize HashMap – Collections.synchronizedMap()
     * */
    @Test
    public void test2() {
        Map<Integer, String> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

        synchronizedMap.put(1, "A");
        synchronizedMap.put(2, "B");
        synchronizedMap.put(3, "C");
        synchronizedMap.put(4, "D");
        synchronizedMap.put(5, "E");

        String value = synchronizedMap.get(1);
        System.out.println(value);

        Iterator<Integer> itr = synchronizedMap.keySet().iterator();
        while (itr.hasNext()) {
            Integer k = itr.next();
            String v = synchronizedMap.get(k);
            System.out.println(k + "===" + v);
        }
    }
}