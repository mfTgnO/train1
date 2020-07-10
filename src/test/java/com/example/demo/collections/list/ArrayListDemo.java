package com.example.demo.collections.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * add
     * <p>
     * add() method first ensures that there is sufficient space in the arraylist.
     * If list does not have space, then it grows the list by adding more spaces in underlying array.
     * Then it add the element to specific array index.
     */
    @Test
    public void test3() {
        List<String> names = new ArrayList<>();
        names.add("alex");
        names.add("brian");
        names.add("charles");
        System.out.println(names);
    }

    /**
     * addAll(Collection<? extends E> c);
     * <p>
     * addAll() method first ensures that there is sufficient space in the arraylist.
     * If list does not have space, then it grows the list by adding more spaces in underlying array.
     * Then it append the elements to end of the list.
     */
    @Test
    public void test4() {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");

        List<String> list2 = new ArrayList<>();
        list2.add("E");

        list1.addAll(list2);
        System.out.println(list1);
    }

    /**
     * addAll(int index, Collection<? extends E> c);
     */
    @Test
    public void test5() {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");

        List<String> list2 = new ArrayList<>();
        list2.add("E");
        list2.add("F");

        list1.addAll(2, list2);
        System.out.println(list1);
    }

    /**
     * ArrayList clear() method is used to removes all of the elements from the list. The list will be empty after this call returns.
     * <p>
     * clear() method does simple thing. It iterates the backing array inside arraylist and assign all elements 'null' value and set the size attribute to '0'.
     * <p>
     * ArrayList clear vs new
     * An empty arraylist has zero elements. A new arraylist also has zero elements. But there is differenece between them.
     * The difference between an empty and a new arraylist is the size of backing array.
     * As clear() method does not resize the backing array, so after clear method you may have a list which has backing array of a larger size (if list was pretty big before clear() method was called).
     * Except above difference in capacity, there is no difference between both kind of lists.
     */
    @Test
    public void test6() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list);
        list.clear();
        System.out.println(list);
    }

    /**
     * ArrayList clone() – Shallow Copy
     * <p>
     * ArrayList clone() method is used to create a shallow copy of the list. In the new list, only object references are copied.
     * If we change the object state inside first arraylist, then changed object state will be reflected in cloned arraylist as well.
     */
    @Test
    public void test7() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list);
        ArrayList clone = (ArrayList) list.clone();
        System.out.println(clone);

        System.out.println("modify");
//        list.set(0, "AA");
        list.remove(3);
        System.out.println(list);
        System.out.println(clone);
    }

    /**
     *
     */
    @Test
    public void test8() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            Integer num = arrayList.get(i);
            if (3 == num) {
                arrayList.remove(i);
                arrayList.add(0, num);
            }
        }
        System.out.println(arrayList);
    }

    /**
     * list addAll
     */
    @Test
    public void test10() {
        List<Map<String, Object>> list1 = new ArrayList<>();
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("A1", "A1");
        map1.put("A2", "A2");
        map1.put("A3", "A3");
        list1.add(map1);

        List<Map<String, Object>> list2 = new ArrayList<>();
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("B1", "B1");
        map2.put("B2", "B2");
        map2.put("B3", "B3");
        list2.add(map2);

        List<Map<String, Object>> list3 = new ArrayList<>();

        list3.addAll(list2);
        System.out.println(list3);
        list3.addAll(0, list1);
        System.out.println(list3);
    }
}