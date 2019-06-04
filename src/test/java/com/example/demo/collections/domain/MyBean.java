package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.ToString;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-06-04 17:11
 * @description:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "id"})
//@JsonPropertyOrder({"id", "name"})
@ToString
public class MyBean {
    public int id;
    public String name;

    public MyBean() {
    }

    public MyBean(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    @JsonGetter("name")
    public String getTheName() {
        return name;
    }

    @JsonSetter("name")
    public void setTheName(String name) {
        this.name = name;
    }
}
