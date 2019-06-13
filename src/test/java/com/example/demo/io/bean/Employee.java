package com.example.demo.io.bean;

import lombok.ToString;

import java.io.Serializable;

/**
 * @package: com.example.demo.io.bean
 * @author:
 * @email:
 * @createDate: 2019-06-13 20:40
 * @description:
 */
@ToString
public class Employee implements Serializable {

    private static final long serialVersionUID = -4738393434007151047L;
    private String name;
    private String gender;
    private int age;

    public Employee() {
    }

    public Employee(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
