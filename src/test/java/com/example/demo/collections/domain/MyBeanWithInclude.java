package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @package: com.example.demo.collections.model
 * @author:
 * @email:
 * @createDate: 2019-06-05 10:24
 * @description:
 */

/*
 * @JsonInclude is used to exclude properties with empty/null/default values.
 * Let’s look at an example – excluding nulls from serialization:
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyBeanWithInclude {
    public int id;
    public String name;

    public MyBeanWithInclude(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
