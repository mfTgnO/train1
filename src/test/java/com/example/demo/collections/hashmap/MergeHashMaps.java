package com.example.demo.collections.hashmap;

import org.junit.Test;

import java.util.HashMap;

/**
 * @package: com.example.demo.collections.hashmap
 * @author:
 * @email:
 * @createDate: 2019-06-10 15:18
 * @description:
 */
public class MergeHashMaps {

    /*
     * 1. Merge two hashmaps – ignore duplicate keys
     * This one is simple solution. Simply use HashMap.putAll(HashMap) method
     * which copies all of the mappings from the second map to first map.
     * As we know hashmap does not allow duplicate keys. So when we merge the
     * maps in this way, for duplicate keys in map1 the value is overwitten by value for same key in map2.
     * */
    @Test
    public void test1() {
        //map 1
        HashMap<Integer, String> map1 = new HashMap<>();

        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");
        map1.put(5, "E");

        //map 2
        HashMap<Integer, String> map2 = new HashMap<>();

        map2.put(1, "G");   //It will replace the value 'A'
        map2.put(2, "B");
        map2.put(3, "C");
        map2.put(4, "D");   //A new pair to be added

        //Merge maps
        map1.putAll(map2);

        System.out.println(map1);
    }

    /*
     * 2. Java 8 combine two hashmaps – handle duplicate keys
     * If we want to handle the cases where duplicate keys are present in the maps and we do not want to
     * loose the data for any map and for any key. In this case, we can take help of HashMap.merge() function added in Java 8.
     * merge() function 3 arguments. Key, value and uses a user-provided BiFunction to
     * merge values for duplicate keys.
     * In our example, we want to append both the strings when a duplicate key is
     * found ONLY WHEN the value is different from previous values associated with key in map1.
     * */
    @Test
    public void test2() {
        //map 1
        HashMap<Integer, String> map1 = new HashMap<>();

        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");
        map1.put(5, "E");

        //map 2
        HashMap<Integer, String> map2 = new HashMap<>();

        map2.put(1, "G");   //It will replace the value 'A'
        map2.put(2, "B");
        map2.put(3, "C");
        map2.put(4, "D");   //A new pair to be added

        //Merge maps
        map2.forEach(
                (key, value) -> map1.merge(key, value, (v1, v2) -> v1.equalsIgnoreCase(v2) ? v1 : v1 + "," + v2)
        );

        System.out.println(map1);
    }
}
