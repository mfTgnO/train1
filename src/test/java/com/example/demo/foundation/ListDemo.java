package com.example.demo.foundation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
}
