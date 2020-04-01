package com.example.demo.collections.map;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @package: com.example.demo.collections.hashmap
 * @author:
 * @email:
 * @createDate: 2019-06-10 14:09
 * @description:
 *
 * 5. HashMap MethodsList of methods in HashMap class and their short description.
 * 	1.
 * void clear() : removes all the key-value pairs from the HashMap.
 * 	2.
 * Object clone() : returns a shallow copy of the specified HashMap.
 * 	3.
 * boolean containsKey(Object key) : returns true or false based on whether the specified key is found in the map or not.
 * 	4.
 * boolean containsValue(Object Value) : Similar to containsKey() method, it looks for the specified value instead of key.
 * 	5.
 * Object get(Object key) : returns the value for the specified key in the HashMap.
 * 	6.
 * boolean isEmpty() : checks whether the map is empty.
 * 	7.
 * Set keySet() : returns the Set of the all keys stored in the HashMap.
 * 	8.
 * Object put(Key k, Value v) : Inserts key-value pair into the HashMap.
 * 	9.
 * int size() : returns the size of the map which is equal to the number of key-value pairs stored in the HashMap.
 * 	10.
 * Collection values() : returns a collection of all invalues the map.
 * 	11.
 * Value remove(Object key) : removes the key-value pair for the specified key.
 * 	12.
 * void putAll(Map m) : copies all the elements of a map to the another specified map.
 */
public class HashMapIntroduction {
    public static Map<Integer, String> map = new HashMap<>();

    /*
     * 4.1. Add key-value – HashMap.put()
     * */
    @Before
    public void getUnSortedMap() {
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
    }

    /*
     * 4.2. Get value by key – HashMap.get()
     * */
    @Test
    public void test1() {
        String value = map.get(2);
        System.out.println(value);
    }

    /*
     * 4.3. Remove pair by key – HashMap.remove()
     * */
    @Test
    public void test2() {
        System.out.println(map);
        map.remove(3);
        System.out.println(map);
    }

    /*
     * 4.4. Iterate a HashMap
     * Please note that iterators of this class are fail-fast and if any
     * structure modification is done after creation of iterator, it will throw ConcurrentModificationException.
     * */
    @Test
    public void test3() {
        System.out.println("//Iterate over keys");

        Iterator<Integer> itr = map.keySet().iterator();
        while (itr.hasNext()) {
            Integer key = itr.next();
            String value = map.get(key);

            System.out.println("The key is :: " + key + ", and value is :: " + value);
        }


        System.out.println("//Iterate over entries set");
        Iterator<Map.Entry<Integer, String>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Integer, String> entry = entryIterator.next();
            System.out.println("The key is :: " + entry.getKey() + ", and value is :: " + entry.getValue());
        }
    }
}
