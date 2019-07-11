package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @package: com.example.demo.collections.model
 * @author:
 * @email:
 * @createDate: 2019-06-04 17:35
 * @description:
 */
@JsonRootName(value = "user")
public class UserWithRoot {
    private int id;
    private String name;

    public UserWithRoot(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
