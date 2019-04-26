package com.example.demo.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-26 18:41
 * @Description:
 */
public class CopyArrayRangeExample {
    // 1) Arrays.copyOfRange()
    @Test
    public void test1() {
        String[] names = {"Alex", "Brian", "Charles", "David"};

        //Copy till second name from with index '0'
        String[] partialNames = Arrays.copyOfRange(names, 0, 2);
        System.out.println(Arrays.toString(partialNames));

        //Copy all names from with index '2'
        String[] endNames = Arrays.copyOfRange(names, 2, names.length);
        System.out.println(Arrays.toString(endNames));

        //Copy last 8 names start with index '2'
        //No ArrayIndexOutOfBoundsException error
        String[] moreNames = Arrays.copyOfRange(names, 2, 10);
        System.out.println(Arrays.toString(moreNames));
    }

    // Array to Sublist
    @Test
    public void test2() {
        String[] names = {"Alex", "Brian", "Charles", "David"};

        //Array to sublist
        List<String> namesList = Arrays.asList(Arrays.copyOfRange(names, 0, 2));
        System.out.println(Arrays.toString(names));
    }
}
