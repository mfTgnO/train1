package com.example.demo.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @package: com.example.demo.collections
 * @author:
 * @email:
 * @createDate: 2019-06-10 13:56
 * @description:
 */
public class ObjectSorting {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Employee implements Comparable<Employee> {
        private int id = -1;
        private String firstName = null;
        private String lastName = null;
        private int age = -1;

        @Override
        public int compareTo(Employee o) {
            return this.id - o.id;
        }
    }

    @Test
    public void testSorting() {
        Employee e1 = new Employee(1, "aTestName", "dLastName", 34);
        Employee e2 = new Employee(2, "nTestName", "pLastName", 30);
        Employee e3 = new Employee(3, "kTestName", "sLastName", 31);
        Employee e4 = new Employee(4, "dTestName", "zLastName", 25);

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(e2);
        employees.add(e3);
        employees.add(e1);
        employees.add(e4);

        // UnSorted List
        employees.forEach(System.out::println);

        Collections.sort(employees);
        System.out.println("");

        // Default Sorting by employee id
        employees.forEach(System.out::println);
    }
}
