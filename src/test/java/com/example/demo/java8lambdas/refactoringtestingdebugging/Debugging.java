package com.example.demo.java8lambdas.refactoringtestingdebugging;

import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-16 10:59
 * @Description:
 */
public class Debugging {
    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream()
                .map(Point::getX)
                .forEach(System.out::println);
    }
}
