package com.example.demo.java8lambdas.domain;

import lombok.Data;

/**
 * @Package: com.example.demo.java8lambdas.model
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

    public enum CaloricLevel {
        DIET, NORMAL, FAT
    }

    public CaloricLevel getCaloricLevel() {
        if (this.getCalories() <= 400) {
            return Dish.CaloricLevel.DIET;
        } else if (this.getCalories() <= 700) {
            return Dish.CaloricLevel.NORMAL;
        }
        return Dish.CaloricLevel.FAT;
    }
}
