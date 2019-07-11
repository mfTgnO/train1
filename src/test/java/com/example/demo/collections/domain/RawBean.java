package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonRawValue;

/**
 * @package: com.example.demo.collections.model
 * @author:
 * @email:
 * @createDate: 2019-06-04 17:21
 * @description:
 */
public class RawBean {
    public String name;

    @JsonRawValue
    public String json;

    public RawBean(String name, String json) {
        this.name = name;
        this.json = json;
    }

    public RawBean() {
    }
}
