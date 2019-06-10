package com.example.demo.collections.sortonmultiplefields;

import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @package: com.example.demo.collections.sortonmultiplefields
 * @author:
 * @email:
 * @createDate: 2019-06-10 13:29
 * @description:
 */
public class MultipleFieldSorterV3 {
    public static void main(String[] args) {
        List<EmployeeCompareToBuilderV2> list = Arrays.asList(new EmployeeCompareToBuilderV2(1, "A", "B", 34),
                new EmployeeCompareToBuilderV2(4, "C", "D", 30),
                new EmployeeCompareToBuilderV2(3, "B", "A", 31),
                new EmployeeCompareToBuilderV2(2, "D", "C", 25));

        Collections.sort(list, (o1, o2) -> new CompareToBuilder()
                .append(o1.getFirstName(), o2.getFirstName())
                .append(o1.getLastName(), o2.getLastName())
                .append(o1.getAge(), o2.getAge())
                .toComparison());

        list.forEach(System.out::println);
    }
}
