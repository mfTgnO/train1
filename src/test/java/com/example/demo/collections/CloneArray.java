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
        Employee[] empArray = new Employee[2];

        empArray[0] = new Employee(100, "Lokesh", "Gupta", new Department(1, "HR"));
        empArray[0] = new Employee(200, "Pankaj", "Kumar", new Department(2, "Finance"));

        Employee[] clonedArray = empArray.clone();

        empArray[0].setFirstName("Unknown");
        empArray[0].getDepartment().setName("Unknown");

        // Verify the change in original array - "CHANGED"
        System.out.println(empArray[0].getFirstName());
        System.out.println(empArray[0].getDepartment().getName());

        // Verify the change in cloned array - "CHANGED"
        System.out.println(clonedArray[0].getFirstName());
        System.out.println(clonedArray[0].getDepartment().getName());
    }

    // Array Deep Copy
    @Test
    public void test2() {
        Employee[] empArray = new Employee[2];

        empArray[0] = new Employee(100, "Lokesh", "Gupta", new Department(1, "HR"));
        empArray[0] = new Employee(200, "Pankaj", "Kumar", new Department(2, "Finance"));

        Employee[] copiedArray = SerializationUtils.clone(empArray);

        empArray[0].setFirstName("Unknown");
        empArray[0].getDepartment().setName("Unknown");

        // Verify the change in original array - "CHANGED"
        System.out.println(empArray[0].getFirstName());
        System.out.println(empArray[0].getDepartment().getName());

        //Verify the change in deep copied array - "UNCHANGED"
        System.out.println(copiedArray[0].getFirstName());
        System.out.println(copiedArray[0].getDepartment().getName());
    }
}
