package com.example.demo.collections.sortonmultiplefields;

import java.util.Comparator;

/**
 * @package: com.example.demo.collections.sortonmultiplefields
 * @author:
 * @email:
 * @createDate: 2019-06-10 13:16
 * @description:
 */
public class FirstNameSorter implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
