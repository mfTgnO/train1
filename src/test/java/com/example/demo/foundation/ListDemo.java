package com.example.demo.foundation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            if (integer == 3 || integer == 5) {
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
}
