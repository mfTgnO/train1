package com.example.demo.java8lambdas.defaultmethods;

import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.example.demo.java8lambdas.defaultmethods
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-17 17:41
 * @Description:
 */
public class Game {
    public static void main(String[] args) {
        List<Resizable> resizableShapes = Arrays.asList(new Square(), new Triangle(), new Ellipse());
        Utils.paint(resizableShapes);
    }
}
