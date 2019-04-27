package com.example.demo.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 10:02
 * @Description:
 */
public class StringToStringArray {
    // 1) Convert String to String[]
    // 1.1) String.split()
    @Test
    public void test1() {
        String names = "alex,brian,charles,david";
        String[] namesArray = null;

        // Split string with comma
        namesArray = names.split(",");

        // Verify array content
        System.out.println(Arrays.toString(namesArray));
    }

    // 1.2) Pattern.split()
    @Test
    public void test2() {
        String names = "alex,brian,charles,david";
        String[] namesArray = null;

        // Split string with comma
        Pattern pattern = Pattern.compile(",");
        namesArray = pattern.split(names);

        // Verify array content
        System.out.println(Arrays.toString(namesArray));
    }

    // 2) String[] to String
    @Test
    public void test3() {
        String[] tokens = {"How", "To", "Do", "In", "Java"};
        String blogName1 = String.join("", tokens);
        String blogName2 = String.join(" ", tokens);
        String blogName3 = String.join("-", tokens);

        // Verify string
        System.out.println(blogName1);
        System.out.println(blogName2);
        System.out.println(blogName3);
    }
}