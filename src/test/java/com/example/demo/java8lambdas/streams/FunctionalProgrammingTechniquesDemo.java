package com.example.demo.java8lambdas.streams;

import org.junit.Test;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

/**
 * @package: com.example.demo.java8lambdas.streams
 * @author:
 * @email:
 * @createDate: 2019-05-25 11:06
 * @description:
 */
/*
 * Chapter 14. Functional programming techniques
 * */
public class FunctionalProgrammingTechniquesDemo {
    /*
     * 14.1. Functions everywhere
     * */
    @Test
    public void test1() {
        Function<String, Integer> strToInt = Integer::parseInt;
        Integer i = strToInt.apply("2019");

        System.out.println(i);
        System.out.println(i.getClass());
    }

    /*
     * 14.1.2. Currying
     * */
    @Test
    public void test2() {
        DoubleUnaryOperator convertCtoF = curriedConverter(9.0 / 5, 32);
        DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
        DoubleUnaryOperator covnertKmtoMi = curriedConverter(0.6214, 0);

        /*
         * Because DoubleUnaryOperator defines a method applyAsDouble, you can use your converters as follows:
         * */
        double gbp = convertUSDtoGBP.applyAsDouble(1000);
        System.out.println(gbp);
    }

    DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }
}
