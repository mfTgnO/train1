package com.example.demo.designpattern.bridgepattern;

/**
 * @package: com.example.demo.designpattern.bridgepattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:03
 * @description:
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}
