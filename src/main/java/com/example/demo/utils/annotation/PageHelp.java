package com.example.demo.utils.annotation;

import java.lang.annotation.*;

/**
 * @package: com.example.demo.utils.annotation
 * @author:
 * @email:
 * @createDate: 2019-06-13 17:43
 * @description:
 */

@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageHelp {
}
