package com.example.demo.collections;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-26 18:26
 * @Description:
 */
public class Print2DArray {
    // 1) Arrays.deepToString()
    @Test
    public void test1() {
        int[][] cordinates = {{1, 2}, {2, 4}, {3, 6, 9}};
        System.out.println(Arrays.deepToString(cordinates));
    }

    @Test
    public void test2() {
        int[][] arr = {{1, 2}, {2, 4}, {3, 6, 9}};

        StringBuilder builder = new StringBuilder();
        // Open bracket
        builder.append("[");

        // Loop through all rows and print
        for (int i = 0; i < arr.length; i++) {
            builder.append(Arrays.toString(arr[i]) + ", ");
        }

        // Delete last two characters
        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);

        //Close bracket
        builder.append("]");

        System.out.println(builder.toString());
    }
}
