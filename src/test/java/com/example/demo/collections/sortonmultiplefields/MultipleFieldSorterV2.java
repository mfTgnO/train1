package com.example.demo.collections.sortonmultiplefields;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @package: com.example.demo.collections.sortonmultiplefields
 * @author:
 * @email:
 * @createDate: 2019-06-10 13:26
 * @description:
 */
public class MultipleFieldSorterV2 {
    public static void main(String[] args) {
        List<EmployeeCompareToBuilder> list = Arrays.asList(new EmployeeCompareToBuilder(1, "A", "B", 34),
                new EmployeeCompareToBuilder(4, "C", "D", 30),
                new EmployeeCompareToBuilder(3, "B", "A", 31),
                new EmployeeCompareToBuilder(2, "D", "C", 25));

        Collections.sort(list);

        System.out.println(list);
    }
}
