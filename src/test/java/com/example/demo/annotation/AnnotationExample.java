package com.example.demo.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.example.demo.annotation
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-26 18:04
 * @Description:
 */
public class AnnotationExample {
    public static void main(String[] args) {

    }

    @Override
    @MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revision = 1)
    public String toString() {
        return "Overriden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revision = 10)
    public static void genericsTest() {
        List list = new ArrayList<>();
        list.add("abs");
        oldMethod();
    }
}
