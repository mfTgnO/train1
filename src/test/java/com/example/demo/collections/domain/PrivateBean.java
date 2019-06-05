package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-06-05 10:27
 * @description:
 */
/*
 * @JsonAutoDetect is used to override the default semantics of which properties are visible and which are not.
 * Let’s take a look at how the annotation can be very helpful with a simple example – let’s enable serializing private properties:
 * */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PrivateBean {
    private int id;
    private String name;

    public PrivateBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
