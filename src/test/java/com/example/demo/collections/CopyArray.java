package com.example.demo.collections;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-26 18:36
 * @Description:
 */
public class CopyArray {
    // 1) Create Array Clone
    @Test
    public void test1() {
        String[] names = {"Alex", "Brian", "Charles", "David"};

        // Use arr.clone() method - Recommended
        String[] cloneOfNames = names.clone();

        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(cloneOfNames));
    }

    // 2) Arrays.copyOf()
    @Test
    public void test2() {
        String[] names = {"Alex", "Brian", "Charles", "David"};

        // Use Arrays.copyOf() method - Most readable
        String[] cloneOfNames = Arrays.copyOf(names, names.length);

        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(cloneOfNames));
    }

    // 3) System.arraycopy()
    @Test
    public void test3() {
        String[] names = {"Alex", "Brian", "Charles", "David"};

        //Using System.arraycopy() method - Equally efficient but less readable
        String[] copyOfNames = new String[names.length];
        System.arraycopy(names, 0, copyOfNames, 0, copyOfNames.length);

        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(copyOfNames));
    }
}
