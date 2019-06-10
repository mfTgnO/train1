package com.example.demo.designpattern.bridgepattern;

/**
 * @package: com.example.demo.designpattern.bridgepattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:03
 * @description:
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
