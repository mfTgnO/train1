package com.example.demo.foundation.regex;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Demo1 {
    @Test
    public void test1() {
        String str1 = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\\\d+)(.*)";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str1);

        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void test2() {
//        String str1 = "123、我国的火警报警电话是（ ）？";
//        String str1 = "1我国的火警报警电话是（ ）？";
//        String str2 = "1.我国的火警报警电话是（ ）？";
//        String str2 = "1我国的火警报警电话是（ ）？";
        String str3 = "我国的火警报警电话是（ ）？";
        String pattern1 = "^[0-9]";
        String pattern2 = "^[0-9]+[、.]";

        Pattern r = Pattern.compile(pattern2);
//        Matcher m = r.matcher(str1);
        Matcher m = r.matcher(str3);
//        Matcher m = r.matcher(str3);

        if (m.find()) {
            String str = m.group(0);
            System.out.println("Found value: " + m.group(0));

            int index = str3.indexOf(str);
            System.out.println(index);

            String[] split = str3.split(pattern2);
            System.out.println(split[0]);
            System.out.println(split[1]);
//            System.out.println("Found value: " + m.group(1));
//            System.out.println("Found value: " + m.group(2));
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void test3() {
        String str1 = "A.整个屏幕";
//        String str1 = "A、整个屏幕";
        String pattern2 = "^[A-Z]+[、.]";

        Pattern r = Pattern.compile(pattern2);
        Matcher m = r.matcher(str1);

        if (m.find()) {
            String str = m.group(0);
            System.out.println("Found value: " + m.group(0));

            int index = str1.indexOf(str);
            System.out.println(index);

            String[] split = str1.split(pattern2);
            System.out.println(split[0]);
            System.out.println(split[1]);
//            System.out.println("Found value: " + m.group(1));
//            System.out.println("Found value: " + m.group(2));
        } else {
            System.out.println("NO MATCH");
        }
    }
}