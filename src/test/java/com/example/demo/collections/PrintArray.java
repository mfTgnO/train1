package com.example.demo.collections;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-26 18:20
 * @Description:
 */
public class PrintArray {
    // 1) Arrays.toString() – Print array content
    @Test
    public void printArrayContent() {
        // An array of String objects
        String[] array = new String[]{"First", "Second", "Third", "Fourth"};

        // Print the array using Arrays.toString()
        System.out.println(Arrays.toString(array));
    }

    // 2) Arrays.deepToString() – Print array of arrays
    @Test
    public void printArrayOfArrays() {
        String[] arr1 = new String[]{"Fifth", "Sixth"};
        String[] arr2 = new String[]{"Seventh", "Eight"};

        // An array of array containing String objects
        String[][] arrayOfArray = new String[][]{arr1, arr2};

        // Compare the different outputs

        // Print the array using default toString method
        System.out.println(arrayOfArray);

        // Print the array using Arrays.toString()
        System.out.println(Arrays.toString(arrayOfArray));

        // Print the array using Arrays.deepToString()
        // Correct way
        System.out.println(Arrays.deepToString(arrayOfArray));
    }
}
