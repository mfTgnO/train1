package com.example.demo.designpattern.bridgepattern;

/**
 * @package: com.example.demo.designpattern.bridgepattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:04
 * @description:
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
