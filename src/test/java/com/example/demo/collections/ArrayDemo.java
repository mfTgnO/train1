package com.example.demo.collections;

import com.example.demo.collections.domain.Department;
import com.example.demo.collections.domain.Employee;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * @Package: com.example.demo.collections
 * @CreateDate: 2019-04-27 10:47
 */
public class ArrayDemo {

    private String[] nameArray;

    // 1. Intersection between two integer arrays
    @Test
    public void test1() {
        Integer[] firstArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] secondArray = {1, 3, 5, 7, 9};

        Set<Integer> set = new HashSet<>();

        set.addAll(Arrays.asList(firstArray));
        set.retainAll(Arrays.asList(secondArray));

        System.out.println(set);

        // convert to array
        Integer[] intersection = {};
        intersection = set.toArray(intersection);

        System.out.println(Arrays.toString(intersection));
    }

    // 2. Intersection between two string arrays
    @Test
    public void test2() {
        String[] firstArray = {"A", "B", "C", "D"};
        String[] secondArray = {"D", "A", "E", "F"};

        Set<String> set = new HashSet<>();

        set.addAll(Arrays.asList(firstArray));
        set.retainAll(Arrays.asList(secondArray));

        System.out.println(set);

        // convert to array
        String[] intersection = {};
        intersection = set.toArray(intersection);

        System.out.println(Arrays.toString(intersection));
    }

    /*
     * Java Array Clone – Deep Copy vs Shallow Copy
     * https://howtodoinjava.com/array/java-array-clone-shallow-copy/
     *
     * In Java, to create clone of array, you should use clone() method of array. It creates a shallow copy of array.
     * Cloning always creates shallow copy of array. Any change (in original array) will be reflected in cloned array as well.
     * */
    @Test
    public void test3() {
        Employee[] empArray = new Employee[2];
        empArray[0] = new Employee(100, "Lokesh", "Gupta", new Department(1, "HR"));
        empArray[1] = new Employee(200, "Pankaj", "Kumar", new Department(2, "Finance"));

        Employee[] clonedArray = empArray.clone();

        empArray[0].setFirstName("Unknown");
        empArray[0].getDepartment().setName("Unknown");

        //Verify the change in original array - "CHANGED"
        System.out.println(empArray[0].getFirstName());                     //Unknown
        System.out.println(empArray[0].getDepartment().getName());          //Unknown

        //Verify the change in cloned array - "CHANGED"
        System.out.println(clonedArray[0].getFirstName());                  //Unknown
        System.out.println(clonedArray[0].getDepartment().getName());       //Unknown
    }

    /**
     * Array Deep Copy
     * If you want to create deep copy of an array in Java, then use Apache Common’s SerializationUtils.clone( array ) method.
     */
    @Test
    public void test4() {
        Employee[] empArray = new Employee[2];
        empArray[0] = new Employee(100, "Lokesh", "Gupta", new Department(1, "HR"));
        empArray[1] = new Employee(200, "Pankaj", "Kumar", new Department(2, "Finance"));

        Employee[] clonedArray = SerializationUtils.clone(empArray);

        empArray[0].setFirstName("Unknown");
        empArray[0].getDepartment().setName("Unknown");

        //Verify the change in original array - "CHANGED"
        System.out.println(empArray[0].getFirstName());                     //Unknown
        System.out.println(empArray[0].getDepartment().getName());          //Unknown

        //Verify the change in cloned array - "CHANGED"
        System.out.println(clonedArray[0].getFirstName());                  //Unknown
        System.out.println(clonedArray[0].getDepartment().getName());       //Unknown
    }

    // 1. Union between two integer arrays
    @Test
    public void test5() {
        Integer[] firstArray = {0, 2, 4, 6, 8};
        Integer[] secondArray = {1, 3, 5, 7, 9};

        List<Integer> list1 = Arrays.asList(firstArray);
        List<Integer> list2 = Arrays.asList(secondArray);

        Set<Integer> set = new HashSet<>();

        set.addAll(list1);
        set.addAll(list2);

        System.out.println(set);

        // convert to array
        Integer[] union = {};
        union = set.toArray(union);

        System.out.println(Arrays.toString(union));
    }

    // 2. Union between two string arrays
    @Test
    public void test6() {
        String[] firstArray = {"A", "B", "C", "D"};
        String[] secondArray = {"D", "A", "E", "F"};

        Set<String> set = new HashSet<>();

        set.addAll(Arrays.asList(firstArray));
        set.addAll(Arrays.asList(secondArray));

        System.out.println(set);

        // convert to array
        String[] union = {};
        union = set.toArray(union);

        System.out.println(Arrays.toString(union));
    }

    // 1) Arrays.deepToString()
    @Test
    public void test7() {
        /*int[][] cordinates = {{1, 2}, {2, 4}, {3, 6, 9}};

        int length = cordinates.length;
        System.out.println("length:" + length);
//        cordinates.

        int[][] ints = {};
        for (int i = 0; i < cordinates.length; i++) {
//            int
        }
        cordinates[3] = new int[]{1, 2};
        System.out.println(Arrays.deepToString(cordinates));*/

        int[] intArr = {1, 2, 3};
        /*int[] add = ArrayUtils.add(intArr, 4);
        System.out.println(Arrays.toString(add));*/


        Object[][] o = new Object[][]{
                {"专业", "专业", 0, null},
                {"学员", "学员", 0, null},
                {"年级", "年级", 0, null},
        };

        Object[][] objects = new Object[10][];

        for (int i = 0; i < o.length; i++) {
            objects[i] = o[i];
        }
        System.out.println(Arrays.deepToString(objects));

        objects[3] = new Object[]{"年级", "年级", 0, null};
        System.out.println(Arrays.deepToString(objects));

    }

    @Test
    public void test8() {
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

    @Test
    public void test9() {
        String name = "howtodoinjava.com";

        byte[] byteArray = name.getBytes();

        String str = new String(byteArray);
        String strWithCharset = new String(byteArray, Charset.defaultCharset());

        System.out.println("Original String: " + name);
        System.out.println("Obtained String: " + str);
        System.out.println("Obtained String: " + strWithCharset);
    }

    /**
     * default charset
     */
    @Test
    public void test10() {
        Charset charset = Charset.defaultCharset();
        System.out.println(charset);
    }

    // Base64 class in Java 8
    // As you might be aware of – Base64 is a way to encode binary data, while UTF-8 and UTF-16 are ways to encode Unicode text data. So if you need to encode arbitrary binary data as text, Base64 is the way to go.
    // byte array to string
    @Test
    public void test11() {
        String name = "howtodoinjava.com";
        byte[] byteArray = name.getBytes();

        String str = Base64.getEncoder().encodeToString(byteArray);
        System.out.println(str);

        byte[] decode = Base64.getDecoder().decode(str);
        System.out.println(new String(decode));
    }

    /**
     * Java String to String[] Example
     * https://howtodoinjava.com/array/string-to-string-array/
     * <p>
     * String.split()
     * Use split() method to split string into tokens by passing a delimiter (or regex) as method argument.
     */
    @Test
    public void test12() {
        // Convert String to String[]
        String names = "alex,brian,charles,david";
        String[] namesArray = null;

        namesArray = names.split(",");
        System.out.println(Arrays.asList(namesArray));
    }

    /**
     * Pattern.split()
     * In Java, Pattern is the compiled representation of a regular expression.
     * Use Pattern.split() method to convert string to string array, and using pattern as delimiter.
     */
    @Test
    public void test13() {
        String names = "alex,brian,charles,david";
        String[] namesArray = null;

        Pattern pattern = Pattern.compile(",");
        namesArray = pattern.split(names);
        System.out.println(Arrays.asList(namesArray));
    }

    /**
     * String[] to String
     * <p>
     * Use String.join() method to create string from String array. You need to pass two method arguments i.e.
     * 1.delimiter – the delimiter that separates each element
     * 2.array elements – the elements to join together
     * <p>
     * It will then return a new string that is composed of the ‘array elements’ separated by the ‘delimiter’.
     */
    @Test
    public void test14() {
        String[] tokens = {"How", "To", "Do", "In", "Java"};
        String str1 = String.join(",", tokens);
        String str2 = String.join(" ", tokens);
        String str3 = String.join("-", tokens);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

    /**
     * Remove duplicate elements in Array in Java
     * https://howtodoinjava.com/array/array-remove-duplicate-elements/
     */
    @Test
    public void test15() {
        Integer[] numbers = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(numbers));

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(numbers));
        Integer[] numbersWithoutDuplicates = linkedHashSet.toArray(new Integer[]{});
        System.out.println(Arrays.toString(numbersWithoutDuplicates));
    }

    /**
     * Remove duplicate elements in array using temporary array
     */
    @Test
    public void test16() {
        int[] numbers = {1, 2, 1, 2, 3};
        System.out.println(Arrays.toString(numbers));

        int[] ints = removeDuplicates(numbers);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * How to efficiently remove duplicates from an array without using Set
     * https://stackoverflow.com/questions/17967114/how-to-efficiently-remove-duplicates-from-an-array-without-using-set
     */
    public static int[] removeDuplicates(int[] arr) {
        int end = arr.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (arr[i] == arr[j]) {
                    int shiftLeft = j;
                    for (int k = j + 1; k < end; k++, shiftLeft++) {
                        arr[shiftLeft] = arr[k];
                    }
                    end--;
                    j--;
                }
            }
        }

        int[] whitelist = new int[end];
        for (int i = 0; i < end; i++) {
            whitelist[i] = arr[i];
        }
        return whitelist;
    }

    @Test
    public void test17() {
        String[] arr = "案例的风沙空间".split("");
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println(arr);
    }

    /**
     * Alternative Sorting
     * https://www.geeksforgeeks.org/alternative-sorting/
     * <p>
     * Given an array of integers, print the array in such a way that the first element is first
     * maximum and second element is first minimum and so on.
     * <p>
     * Time Complexity: O(n Log n)
     * Auxiliary Space : O(1)
     */
    @Test
    public void test18() {
        int arr[] = {7, 1, 2, 3, 4, 5, 6};
        int n = arr.length;

        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i < j) {
            System.out.print(arr[j--] + " ");
            System.out.print(arr[i++] + " ");
        }
        if (n % 2 != 0) {
            System.out.print(arr[i++] + " ");
        }
    }

    /**
     * Sort a nearly sorted (or K sorted) array
     * https://www.geeksforgeeks.org/nearly-sorted-algorithm/
     * <p>
     * Given an array of n elements, where each element is at most k away from its target position,
     * devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2,
     * an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
     */
    @Test
    public void test19() {
        int arr[] = {6, 5, 3, 2, 8, 10, 9};
//        insertionSort(arr, arr.length);
        int k = 3;
        KSort(arr, arr.length, k);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * We can use Insertion Sort to sort the elements efficiently. Following is the C code for standard Insertion Sort.
     * <p>
     * The inner loop will run at most k times. To move every element to its correct place, at most k elements need to be moved. So overall complexity will be O(nk)
     * We can sort such arrays more efficiently with the help of Heap data structure. Following is the detailed process that uses Heap.
     * 1) Create a Min Heap of size k+1 with first k+1 elements. This will take O(k) time (See this GFact)
     * 2) One by one remove min element from heap, put it in result array, and add a new element to heap from remaining elements.
     */
    static void insertionSort(int A[], int size) {
        int i, key, j;
        for (i = 0; i < size; i++) {
            key = A[i];
            j = i - 1;
             /* Move elements of A[0..i-1], that are greater than key, to one
                position ahead of their current position.
                This loop will run at most k times */
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = key;
        }
    }

    static void KSort(int[] arr, int n, int k) {
        // min heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // add first k + 1 items to the min heap
        for (int i = 0; i < k + 1; i++) {
            priorityQueue.add(arr[i]);
        }

        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }

        Iterator<Integer> itr = priorityQueue.iterator();
        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }

    /**
     * Sort an array according to absolute difference with given value
     * https://www.geeksforgeeks.org/sort-an-array-according-to-absolute-difference-with-given-value/
     * <p>
     * Given an array of n distinct elements and a number x, arrange array elements according to the absolute difference with x, i. e.,
     * element having minimum difference comes first and so on.
     * Note : If two or more elements are at equal distance arrange them in same sequence as in the given array.
     * <p>
     * The idea is to use a self balancing binary search tree. We traverse input array and for every element,
     * we find its difference with x and store the difference as key and element as value in self balancing binary search tree.
     * Finally we traverse the tree and print its inorder traversal which is required output.
     * <p>
     * C++ Implementation :
     * In C++, self-balancing-binary-search-tree is implemented by set, map and multimap. We can’t use set here as we have key value pairs (not only keys).
     * We also can’t directly use map also as a single key can belong to multiple values and map allows a single value for a key.
     * So we use multimap which stores key value pairs and can have multiple values for a key.
     * <p>
     * Store the values in the multimap with the difference with X as key.
     * In multimap, the values will be already in sorted order according to key i.e. difference with X because it implements self-balancing-binary-search-tree internally.
     * Update all the values of array with the values of map so that array has the required output.
     * filter_none
     */
    @Test
    public void test20() {
        int arr[] = {10, 5, 3, 9, 2};
        int n = arr.length;
        int x = 7;
        rearrange(arr, n, x);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Function to sort an array according absolute difference with x.
     */
    static void rearrange(int[] arr, int n, int x) {
        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();

        // Store values in a map with the difference with X as key
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(x - arr[i]);
            if (treeMap.containsKey(diff)) {
                ArrayList<Integer> al = treeMap.get(diff);
                al.add(arr[i]);
                treeMap.put(diff, al);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(arr[i]);
                treeMap.put(diff, al);
            }
        }

        // Update the values of array
        int index = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : treeMap.entrySet()) {
            List<Integer> al = treeMap.get(entry.getKey());
            for (int i = 0; i < al.size(); i++) {
                arr[index++] = al.get(i);
            }
        }
    }

    /**
     * Sort an array in wave form
     * https://www.geeksforgeeks.org/sort-array-wave-form-2/
     * <p>
     * Given an unsorted array of integers, sort the array into a wave like array.
     * An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
     */
    @Test
    public void test21() {
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        int n = arr.length;
        sortInWave(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    static void sortInWave(int arr[], int n) {
        // Sort the input array
        Arrays.sort(arr);

        // Swap adjacent elements
        for (int i = 0; i < n - 1; i += 2) {
            swap(arr, i, i + 1);
        }
    }

    /**
     * A utility method to swap two numbers.
     */
    static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Merge an array of size n into another array of size m+n
     * https://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
     * <p>
     * Time Complexity: O(m+n)
     */
    @Test
    public void test22() {
        MergeArrays mergeArrays = new MergeArrays();
        /* Initialize arrays */
        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int N[] = {5, 7, 9, 25};
        int n = N.length;
        int m = mPlusN.length - n;

        // Move the m elements at the end of mPlusN
        mergeArrays.moveToEnd(mPlusN, m + n);

        // Merge N[] into mPlusN[]
        mergeArrays.merge(mPlusN, N, m, n);

        // Print the resultant mPlusN
        mergeArrays.printArray(mPlusN, m + n);
    }

    class MergeArrays {
        void moveToEnd(int mPlusN[], int size) {
            int i, j = size - 1;
            for (i = size - 1; i >= 0; i--) {
                if (mPlusN[i] != -1) {
                    mPlusN[j] = mPlusN[i];
                    j--;
                }
            }
        }

        /**
         * Merges array N[] of size n into array mPlusN[] of size m+n
         */
        void merge(int mPlusN[], int N[], int m, int n) {
            int i = n;
            /* Current index of i/p part of mPlusN[]*/
            int j = 0;

            /* Current index of N[]*/
            int k = 0;

            /* Current index of output mPlusN[]*/
            while (k < (m + n)) {
                /* Take an element from mPlusN[] if
                    a) value of the picked element is smaller and we have not reached end of it
                     b) We have reached end of N[] */
                if ((i < (m + n) && mPlusN[i] <= N[j]) || (j == n)) {
                    mPlusN[k] = mPlusN[i];
                    k++;
                    i++;
                } else {
                    // Otherwise take element from N[]
                    mPlusN[k] = N[j];
                    k++;
                    j++;
                }
            }
        }

        /**
         * Utility that prints out an array on a line
         */
        void printArray(int arr[], int size) {
            int i;
            for (i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Sort an array which contain 1 to n values
     * https://www.geeksforgeeks.org/sort-array-contain-1-n-values/
     * <p>
     * You have given an array which contain 1 to n element, your task is to sort this array in an efficient way and without replace with 1 to n numbers.
     * <p>
     * Native approach :
     * Sort this array with the use of any type of sorting method. it takes O(nlogn) minimum time.
     * <p>
     * Efficient approach :
     * Replace every element with it’s position. it takes O(n) efficient time and give you the sorted array. Let’s understand this approach with the code below.
     */
    @Test
    public void test23() {
        int arr[] = {10, 7, 9, 2, 8, 3, 5, 4, 6, 1};
        int n = arr.length;

        sortit(arr, n);

        System.out.println(Arrays.toString(arr));
    }

    void sortit(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
    }

    /**
     * Sort 1 to N by swapping adjacent elements
     * https://www.geeksforgeeks.org/sort-1-n-swapping-adjacent-elements/
     * <p>
     * Given an array, A of size N consisting of elements 1 to N. A boolean array B consisting of N-1 elements indicates that if B[i] is 1,
     * then A[i] can be swapped with A[i+1].
     * Find out if A can be sorted by swapping elements.
     * <p>
     * Here we can swap only A[i] with A[i+1]. So to find whether array can be sorted or not.
     * Using boolean array B we can sort array for a continuous sequence of 1 for B. At last, we can check, if A is sorted or not.
     */
    @Test
    public void test24() {
        int A[] = {1, 2, 5, 3, 4, 6};
//        boolean B[] = {false, true, true, true, false};
        int B[] = {0, 1, 1, 1, 0};
        int n = A.length;
//        if (sortedAfterSwapV1(A, B, n)) {
        if (sortedAfterSwapV2(A, B, n)) {
            System.out.println("A can be sorted");
        } else {
            System.out.println("A can not be sorted");
        }
    }

    /**
     * Return true if array can be sorted otherwise false
     */
    boolean sortedAfterSwapV1(int A[], int B[], int n) {
        int i, j;
        // Check bool array B and sorts elements for continuous sequence of 1
        for (i = 0; i < n - 1; i++) {
            if (B[i] == 1) {
                j = i;
                while (B[j] == 1) {
                    j++;
                }
                // Sort array A from i to j
                Arrays.sort(A, i, 1 + j);
                i = j;
            }
        }

        // Sort array A from i to j
        for (i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return true if array can be sorted otherwise false
     * <p>
     * Alternative Approach
     * Here we discuss a very intuitive approach which too gives the answer in O(n) time for all cases. The idea here is that whenever the binary array has 1, we check if that index in array A has i+1 or not. If it does not contain i+1, we simply swap a[i] with a[i+1].
     * The reason for this is that the array should have i+1 stored at index i. And if at all the array is sortable,
     * then the only operation allowed is swapping. Hence, if the required condition is not satisfied, we simply swap.
     * If the array is sortable, swapping will take us one step closer to the correct answer. And as expected, if the array is not sortable,
     * then swapping would lead to just another unsorted version of the same array.
     */
    boolean sortedAfterSwapV2(int A[], int B[], int n) {
        int t = 0;
        for (int i = 0; i < n - 1; i++) {
            if (B[i] != 0) {
                if (A[i] != i + 1) {
                    t = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = t;
                }
            }
        }

        // Check if array is sorted or not
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sort an array containing two types of elements
     * https://www.geeksforgeeks.org/sort-array-containing-two-types-elements/
     * <p>
     * We are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array. Traverse array only once.
     */
    @Test
    public void test25() {
        int arr[] = {1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1};
        segregate0and1(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Method for segregation 0 and 1 given input array
     */
    void segregate0and1(int arr[], int n) {
        int type0 = 0;
        int type1 = n - 1;

        while (type0 < type1) {
            if (arr[type0] == 1) {
                // swap type0 and type1
                arr[type0] = arr[type0] + arr[type1];
                arr[type1] = arr[type0] - arr[type1];
                arr[type0] = arr[type0] - arr[type1];
                type1--;
            } else {
                type0++;
            }
        }
    }

    /**
     * Sort elements by frequency | Set 1
     * https://www.geeksforgeeks.org/sort-elements-by-frequency/
     * <p>
     * Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.
     */
    @Test
    public void test26() {

    }

    /**
     * Count Inversions in an array | Set 1 (Using Merge Sort)
     * https://www.geeksforgeeks.org/counting-inversions/
     * <p>
     * Inversion Count for an array indicates – how far (or close) the array is from being sorted.
     * If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
     * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
     */
    @Test
    public void test27() {
//        int arr[] = new int[]{1, 20, 6, 4, 5};
//        int arr[] = new int[]{8, 4, 2, 1};
        int arr[] = new int[]{3, 1, 2};

        // METHOD 1
//        getInvCount(arr, arr.length);

        // METHOD 2
        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));
    }

    /**
     * METHOD 1 (Simple)
     * <p>
     * Approach :Traverse through the array and for every index find the number of smaller elements on its right side of the array.
     * This can be done using a nested loop. Sum up the counts for all index in the array and print the sum.
     * <p>
     * Algorithm :
     * Traverse through the array from start to end
     * For every element find the count of elements smaller than the current number upto that index using another loop.
     * Sum up the count of inversion for every index.
     * Print the count of inversions.
     * <p>
     * Complexity Analysis:
     * Time Complexity: O(n^2), Two nested loops are needed to traverse the array from start to end so the Time complexity is O(n^2)
     * Space Compelxity:O(1), No extra space is required.
     */
    void getInvCount(int[] arr, int n) {
        int inv_count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    inv_count++;
                }
            }
        }
        System.out.println("inv_count: " + inv_count);
    }

    /**
     * Function to count the number of inversions during the merge process
     *
     * @return
     */
    int mergeAndCount(int[] arr, int l, int m, int r) {
        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        // Fill from the rest of the left subarray
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Fill from the rest of the right subarray
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return swaps;
    }

    /**
     * Merge sort function
     */
    int mergeSortAndCount(int[] arr, int l, int r) {
        // Keeps track of the inversion count at a particular node of the recursion tree
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;
            // Total inversion count = left subarray count + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, l, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);

            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }
}