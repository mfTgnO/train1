package com.example.demo.foundation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.example.demo.foundation
 * @author:
 * @email:
 * @createDate: 2019-06-19 16:45
 * @description:
 */
public class ForLoopDemo {
    @Test
    public void test() {
        int i = 0;
        for (; ; ) {
            if (i > 10) {
                return;
            }
            i++;
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        int i = 0;
        for (; ; ) {
            if (i == 5) {
                continue;
            }
            i++;
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println(i + " continue");
                continue;
            }
            System.out.println(i);
        }
    }

    @Test
    public void test4() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));

            for (int j = 0; j < list2.size(); j++) {
                System.out.println(list2.get(j));

                if (list2.get(j).toString().equals("b")) {
                    break;
                }
            }

            System.out.println("---------");
        }
    }
}
