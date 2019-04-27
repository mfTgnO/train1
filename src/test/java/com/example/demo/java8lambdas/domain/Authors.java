package com.example.demo.java8lambdas.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Package: com.example.demo.java8lambdas.domain
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 17:32
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Authors {
    Author[] value();
}
