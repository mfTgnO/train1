package com.example.demo.designpattern.factorypattern.demo2;

/**
 * @package: com.example.demo.designpattern.factorypattern.demo2
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:11
 * @description: https://www.journaldev.com/1392/factory-design-pattern-in-java
 */
public class TestFactory {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
        System.out.println("Factory PC Config::" + pc);
        System.out.println("Factory Server Config::" + server);
    }
}
