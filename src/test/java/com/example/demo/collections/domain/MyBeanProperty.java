package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-06-05 10:49
 * @description:
 */
public class MyBeanProperty {
    public int id;
    private String name;

    @JsonProperty("name")
    public void setTheName(String name) {
        this.name = name;
    }

    @JsonProperty("name")
    public String getTheName() {
        return name;
    }

    public MyBeanProperty(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
