package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-06-05 10:10
 * @description:
 */

/*
 * @JsonIgnoreProperties – one of the most common annotations in Jackson – is used to mark a property or a list of properties to be ignored at the class level.
 * Let’s go over a quick example ignoring the property id from serialization:
 * */
//@JsonIgnoreProperties({"id"})
public class BeanWithIgnore {
    /*
     * The @JsonIgnore annotation is used to mark a property to be ignored at the field level.
     * Let’s use @JsonIgnore to ignore the property id from serialization:
     * */
    @JsonIgnore
    public int id;
    public String name;

    public BeanWithIgnore(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
