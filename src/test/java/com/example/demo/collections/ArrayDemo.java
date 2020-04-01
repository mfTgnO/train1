package com.example.demo.collections;

import com.example.demo.collections.domain.Department;
import com.example.demo.collections.domain.Employee;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 10:47
 * @Description:
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
        int[][] cordinates = {{1, 2}, {2, 4}, {3, 6, 9}};
        System.out.println(Arrays.deepToString(cordinates));
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
}