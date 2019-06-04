package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeEnumWithValue {
    TYPE1(1, "Type 1"), TYPE2(2, "Type 2");
    private Integer id;
    private String name;

    TypeEnumWithValue(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    TypeEnumWithValue() {
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
