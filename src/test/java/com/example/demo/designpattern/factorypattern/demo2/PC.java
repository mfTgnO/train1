package com.example.demo.designpattern.factorypattern.demo2;

/**
 * @package: com.example.demo.designpattern.factorypattern.demo2
 * @author:
 * @email:
 * @createDate: 2019-06-10 19:09
 * @description:
 */
public class PC extends Computer {
    private String ram;
    private String hdd;
    private String cpu;

    public PC(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}
