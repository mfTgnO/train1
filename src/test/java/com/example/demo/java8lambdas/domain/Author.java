package com.example.demo.java8lambdas.domain;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Package: com.example.demo.java8lambdas.model
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 17:33
 * @Description:
 */
@Repeatable(Authors.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String name();
}
