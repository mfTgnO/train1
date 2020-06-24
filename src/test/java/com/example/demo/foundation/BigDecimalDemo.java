package com.example.demo.foundation;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class BigDecimalDemo {
    @Test
    public void test1() {
        BigDecimal a = new BigDecimal(20);
        BigDecimal b = new BigDecimal(10);

        BigDecimal result = b.divide(a).setScale(2, ROUND_HALF_UP).multiply(new BigDecimal(100));
        System.out.println(result);
        int i = result.intValue();
        /*double v = result.doubleValue();
        System.out.println(v);

        System.out.println(v * 100 + "%");*/
        System.out.println(i + "%");
    }

    @Test
    public void test2() {
        BigDecimal a = new BigDecimal(20);
        BigDecimal b = new BigDecimal(10);

        /*double percentage = new BigDecimal(1)
                .divide(new BigDecimal(82),4)
//                .setScale(2, ROUND_HALF_UP)
//                .multiply(new BigDecimal(100))
                .doubleValue();
        System.out.println(percentage);
        System.out.println(1/82);*/

        BigDecimal divide = new BigDecimal(1)
                .divide(new BigDecimal(82), 4);
        System.out.println(divide.toString());

        double aa = 1;
        double bb = 82;
        double cc = aa / bb;
        int dd = (int) (cc * 100);
        System.out.println(cc);
        System.out.println(dd);


        /*DecimalFormat df = new DecimalFormat("#.00");
        df.format(你要格式化的数字);*/

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String format = decimalFormat.format(cc);
        System.out.println(format);

    }

    @Test
    public void test3() {
        BigDecimal a;
        BigDecimal b;
        a = new BigDecimal(3);
        b = new BigDecimal(81);
        BigDecimal divide = a.divide(b, 4, RoundingMode.HALF_UP);
        System.out.println(divide);

        double v = divide.doubleValue();
        int p = (int) (v * 100);
        System.out.println(p);
    }

    /**
     * divide
     */
    @Test
    public void test4() {
        double result = new BigDecimal(20)
                .divide(new BigDecimal(82), 2, RoundingMode.HALF_UP)
                .doubleValue();

        System.out.println(result);
    }
}