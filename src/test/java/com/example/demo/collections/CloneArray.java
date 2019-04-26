package com.example.demo.collections;

import com.example.demo.collections.domain.Department;
import com.example.demo.collections.domain.Employee;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

/**
 * @Package: com.example.demo.collections
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-26 18:46
 * @Description:
 */
public class CloneArray {
    // Array Clone – Shallow Copy
    // In Java, to create clone of array, you should use clone() method of array. It creates a shallow copy of array.
    // Cloning always creates shallow copy of array. Any change (in original array) will be reflected in cloned array as well.
    @Test
    public void test1() {
        Employee[] employees = new Employee[2];

        employees[0] = new Employee(100, "Lokesh", "Gupta", new Department(1, "HR"));
        employees[0] = new Employee(200, "Pankaj", "Kumar", new Department(2, "Finance"));

        Employee[] copiedArray = SerializationUtils.clone(employees);
    }
}
