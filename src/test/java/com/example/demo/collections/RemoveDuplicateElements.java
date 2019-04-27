package com.example.demo.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 11:00
 * @Description:
 */
public class RemoveDuplicateElements {
    @Test
    public void test1() {
        //Array with duplicate elements
        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5, 1, 3, 5};

        //This array has duplicate elements
        System.out.println(Arrays.toString(numbers));

        //Create set from array elements
        LinkedHashSet<Integer> set = new LinkedHashSet<>(Arrays.asList(numbers));

        //Get back the array without duplicates
        Integer[] numbersWithoutDuplicates = set.toArray(new Integer[]{});

        //Verify the array content
        System.out.println(Arrays.toString(numbersWithoutDuplicates));
    }

    // 2. Remove duplicate elements in array using temporary array
    // 2.1. Array elements are sorted
    @Test
    public void test2() {
        // Array with duplicate elements
        Integer[] origArray = new Integer[]{1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8};

        // This array has duplicate elements
        System.out.println(Arrays.toString(origArray));
        Integer[] tempArray = removeDuplicatesSort(origArray);

        // Verify the array content
        System.out.println(Arrays.toString(tempArray));

    }

    private static Integer[] removeDuplicatesSort(Integer[] origArray) {

        Integer[] tempArray = new Integer[origArray.length];

        int indexJ = 0;
        for (int indexI = 0; indexI < origArray.length - 1; indexI++) {
            Integer currentElement = origArray[indexI];

            if (currentElement != origArray[indexI + 1]) {
                tempArray[indexJ++] = currentElement;
            }
        }

        tempArray[indexJ++] = origArray[origArray.length - 1];

        return tempArray;
    }

    // 2.2. Remove duplicates when array elements are NOT sorted
    @Test
    public void test3() {
        // Array with duplicate elements
        Integer[] origArray = new Integer[]{1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8};

        // This array has duplicate elements
        System.out.println(Arrays.toString(origArray));

        Integer[] tempArray = removeDuplicateNotSort(origArray);

        // Verify the array content
        System.out.println(Arrays.toString(tempArray));
    }

    private static Integer[] removeDuplicateNotSort(Integer[] origArray) {
        for (int i = 0; i < origArray.length - 1; i++) {
            if (origArray[i] == origArray[i + 1]) {
                origArray[i] = null;
            }
        }
        return origArray;
    }
}
