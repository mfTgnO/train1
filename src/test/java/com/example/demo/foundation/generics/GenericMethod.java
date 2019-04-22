package com.example.demo.foundation.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
 * Q5. How Does a Generic Method Differ From a Generic Type?
 *
 * */
public class GenericMethod {
    private static <T> T returnType(T argument) {
        return argument;
    }

    @Test
    public void test1() {
        Integer inferredInteger = returnType(1);
        System.out.println(inferredInteger);
    }

    @Test
    public void test2() {
        String inferredString = returnType("String");
        System.out.println(inferredString);
    }

    @Test
    public void test3() {
        Long inferredLong = returnType(1L);
        System.out.println(inferredLong);
    }

    @Test
    public void test4() {
        Double inferredDouble = returnType(1D);
        System.out.println(inferredDouble);
    }

    /*
     * Q11. What is an Unbounded Wildcard?
     * */
    @Test
    public void test5() {
        List<?> wildcardList = new ArrayList<String>();
//        List<Object> objectList = new ArrayList<String>(); // Compilation error
    }
}
