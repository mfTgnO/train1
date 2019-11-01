package com.example.demo.foundation;

import org.junit.Test;

import java.util.*;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-26 17:49
 * @description:
 */
public class ListDemo {
    /**
     * 删除list内的元素
     */
    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            if (integer == 3) {
                list.remove(integer);
            }
        }
        System.out.println(list);
    }

    /**
     * removeAll
     */
    @Test
    public void test2() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3));
        System.out.println(list1);

        list1.removeAll(list2);
        System.out.println(list1);
    }

    /**
     * addAll
     */
    @Test
    public void test23() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(list);
        System.out.println(arrayList);
    }

    @Test
    public void test24() {
        String str = "1,2,3";
        List<String> strings = Arrays.asList(str);
        System.out.println(strings);
    }

    @Test
    public void test25() {
        ArrayList<String> list = new ArrayList<>(3);
        list.add("name");
        list.add("age");
        list.add("phone");
        System.out.println(list);
        for (String str : list) {
            if ("phone".equals(str)) {
                list.remove(str);
            }
        }
        System.out.println(list);
    }

    @Test
    public void test26() {
        ArrayList<String> list = new ArrayList<>(3);
        list.add("name");
        list.add("age");
        list.add("phone");


        list.forEach(System.out::println);
    }

    /**
     * 随机获取list中的元素，要求不重复
     */
    @Test
    public void test27() {
        ArrayList<String> list = new ArrayList<>(3);
        list.add("A");
        list.add("B");
        list.add("C");
        ArrayList<Integer> num = new ArrayList<>();
        num.add(0);
        num.add(1);
        num.add(2);

        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            System.out.println("try: " + i);
            int nextInt = random.nextInt(list.size());
            System.out.println("nextInt: " + nextInt);
            System.out.println("list : " + list.get(nextInt));
            list.remove(nextInt);
            System.out.println("========================");
        }
    }

    /**
     * 从大小为n的list中，随机获取m个不重复的元素
     */
    @Test
    public void test28() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        ArrayList<String> selected = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            String name = list.get(new Random().nextInt(list.size()));
            while (selected.contains(name)) {
                name = list.get(new Random().nextInt(list.size()));
            }
            selected.add(name);
        }

        while (hashSet.size() < 4) {
            hashSet.add(list.get(new Random().nextInt(list.size())));
        }
        System.out.println(selected);
        System.out.println(hashSet);
    }
}
