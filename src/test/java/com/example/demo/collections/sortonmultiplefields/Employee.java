package com.example.demo.collections.sortonmultiplefields;

import lombok.Getter;
import lombok.Setter;

/**
 * @package: com.example.demo.collections.sortonmultiplefields
 * @author:
 * @email:
 * @createDate: 2019-06-10 13:16
 * @description:
 */
@Getter
@Setter
public class Employee {
    private Integer id = -1;
    private Integer age = -1;
    private String firstName = null;
    private String lastName = null;

    public Employee(Integer id, String fName, String lName, Integer age) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
    }

    //Getters and Setters

    @Override
    public String toString() {
        return "\nEmployee [id=" + id + ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
