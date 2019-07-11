package com.example.demo.java8lambdas.domain;

import java.util.Arrays;

/**
 * @Package: com.example.demo.java8lambdas.model
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 17:34
 * @Description:
 */
@Author(name = "Raoul")
@Author(name = "Mario")
@Author(name = "Alan")
public class Book {
    public static void main(String[] args) {
        Author[] authors = Book.class.getAnnotationsByType(Author.class);
        Arrays.asList(authors).stream().forEach(a -> {
            System.out.println(a.name());
        });
    }
}
