package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-06-04 16:57
 * @description: https://github.com/eugenp/tutorials/blob/master/jackson-simple/src/test/java/com/baeldung/jackson/annotation/ExtendableBean.java
 */
public class ExtendableBean {
    public String name;
    private Map<String, String> properties;

    public ExtendableBean(final String name) {
        this.name = name;
        properties = new HashMap<>();
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    @JsonAnySetter
    public void add(final String key, final String value) {
        properties.put(key, value);
    }
}
