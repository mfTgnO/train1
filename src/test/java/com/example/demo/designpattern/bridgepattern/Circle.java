package com.example.demo.designpattern.bridgepattern;

/**
 * @package: com.example.demo.designpattern.bridgepattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:03
 * @description:
 */
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
