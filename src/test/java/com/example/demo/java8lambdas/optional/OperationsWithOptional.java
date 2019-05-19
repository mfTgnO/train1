package com.example.demo.java8lambdas.optional;

import java.util.Optional;

/**
 * @Package: com.example.demo.java8lambdas.optional
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-18 14:05
 * @Description:
 */
public class OperationsWithOptional {
    public static final Optional<Integer> max(Optional<Integer> i, Optional<Integer> j) {
        return i.flatMap(a -> j.map(b -> Math.max(a, b)));
    }

    public static void main(String[] args) {
        System.out.println(max(Optional.of(3), Optional.of(5)));
        System.out.println(max(Optional.empty(), Optional.of(5)));

        Optional<Integer> opt1 = Optional.of(5);
        /*Optional<Integer> opt2 = opt1.orElse(() -> Optional.of(4));
        System.out.println(Optional.of(5).or(() -> Optional.of(4)));*/
    }
}
