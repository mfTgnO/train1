package com.example.demo.collections.map;

import org.junit.Test;
import sun.plugin.com.AmbientProperty;

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

    @Test
    public void test2() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");
        System.out.println(map);
        map.remove("0");
        System.out.println(map);
    }
}
