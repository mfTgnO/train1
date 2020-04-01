package com.example.demo.collections.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @createDate: 2019-08-09 14:28
 * @description:
 */
public class HashMapDemo {
    @Test
    public void test1() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", null);

        System.out.println(map.containsKey("hello"));
        System.out.println(map.containsKey("world"));
    }
}
