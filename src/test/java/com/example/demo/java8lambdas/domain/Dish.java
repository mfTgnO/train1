package com.example.demo.java8lambdas.domain;

import lombok.Data;

/**
 * @Package: com.example.demo.java8lambdas.domain
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-29 15:50
 * @Description:
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type {MEAT, FISH, OTHER}
}
