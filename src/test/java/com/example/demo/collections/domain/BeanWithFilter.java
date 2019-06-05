package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-06-05 15:10
 * @description:
 */
/*
 * The @JsonFilter annotation specifies a filter to be used during serialization.
 *Let’s take a look at an example; first, we define the entity, and we point to the filter:
 * */
@JsonFilter("myFilter")
public class BeanWithFilter {
    public int id;
    public String name;

    public BeanWithFilter(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
