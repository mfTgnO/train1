package com.example.demo.java8lambdas.defaultmethods;

import java.util.List;

/**
 * @Package: com.example.demo.java8lambdas.defaultmethods
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-17 17:33
 * @Description:
 */
public class Utils {
    public static void paint(List<Resizable> list) {
        list.forEach(r -> {
            r.setAbsoluteSize(42, 42);
        });
    }
}
