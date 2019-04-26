package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @Package: com.example.demo.annotation
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-26 17:55
 * @Description:
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "Pankaj";

    String date();

    int revision() default 1;

    String comments();
}
