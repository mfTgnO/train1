package com.example.demo.collections.hashmap;

import org.junit.Test;

import java.util.HashSet;

/**
 * @createDate: 2019-08-09 14:42
 * @description:
 */
public class HashSetDemo {
    @Test
    public void test1() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("hello");

        System.out.println(hashSet.contains("hello"));
        System.out.println(hashSet.contains("world"));
    }

    @Test
    public void test2() {
        String id = "";
        String[] urls = {
                "/v1/authenticates",
                "/v1/authenticates/" + id,
//          "/v1/favors/store",
                "/v1/favors/topicFavor",
                "/v1/favors/store/delete",
                "/v1/favors/topicFavor/delete"
        };
        System.out.println(urls.length);
        for (String url : urls) {
            System.out.println("hashSet.add(\"" + url + "\");");
        }
    }
}
