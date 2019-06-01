package com.example.demo.java8lambdas.functional;

import org.junit.Test;

import java.util.function.DoubleUnaryOperator;

/**
 * @package: com.example.demo.java8lambdas.functional
 * @author:
 * @email:
 * @createDate: 2019-06-01 10:41
 * @description:
 */
public class Currying {
    double converter(double x, double y, double z) {
        return x * y + z;
    }

    DoubleUnaryOperator curriedConverter(double y, double z) {
        return (double x) -> x * y + z;
    }

    DoubleUnaryOperator expandedCurriedConveter(double w, double y, double z) {
        return (double x) -> (x + w) * y + z;
    }

    @Test
    public void test1() {
        DoubleUnaryOperator convertCtoF = curriedConverter(9.0 / 5, 32);
        System.out.println(convertCtoF.applyAsDouble(24));
    }

    @Test
    public void test2() {
        DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
        System.out.println(convertUSDtoGBP.applyAsDouble(100));
    }

    @Test
    public void test3() {
        DoubleUnaryOperator convertKmtoMi = curriedConverter(0.6214, 0);
        System.out.println(convertKmtoMi.applyAsDouble(20));
    }

    @Test
    public void test4() {
        DoubleUnaryOperator convertFtoC = expandedCurriedConveter(-32, 5.0 / 9, 0);
        System.out.println(convertFtoC.applyAsDouble(98.6));
    }
}
