package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @package: com.example.demo.collections.model
 * @author:
 * @email:
 * @createDate: 2019-06-05 10:54
 * @description:
 */
@Data
@AllArgsConstructor
public class UnwrappedUser {
    public int id;

    /*
     * @JsonUnwrapped is used for defining values that should be unwrapped/flattened when serialized/deserialized.
     * Let’s see exactly how that works; we’ll use the annotation to unwrap the property name:
     * */
    @JsonUnwrapped
    public Name name;

    @Data
    @AllArgsConstructor
    public static class Name {
        public String firstName;
        public String lastName;
    }
}
