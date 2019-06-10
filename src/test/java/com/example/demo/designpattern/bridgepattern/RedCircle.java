package com.example.demo.designpattern.bridgepattern;

/**
 * @package: com.example.demo.designpattern.bridgepattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:02
 * @description:
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}
