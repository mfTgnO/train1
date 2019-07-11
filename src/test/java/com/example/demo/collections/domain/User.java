package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

/**
 * @package: com.example.demo.collections.model
 * @author:
 * @email:
 * @createDate: 2019-06-05 10:16
 * @description:
 */
public class User {
    public int id;
    public Name name;

    /*
     * @JsonIgnoreType is used to mark all properties of an annotated type to be ignored.
     * Let’s use the annotation to mark all properties of type Name to be ignored:
     * */
    @JsonIgnoreType
    public static class Name {
        public String firstName;
        public String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    public User(int id, Name name) {
        this.id = id;
        this.name = name;
    }
}
