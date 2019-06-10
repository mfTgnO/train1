package com.example.demo.collections.sortonmultiplefields;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @package: com.example.demo.collections.sortonmultiplefields
 * @author:
 * @email:
 * @createDate: 2019-06-10 13:31
 * @description:
 */
@Getter
@Setter
@ToString
public class EmployeeCompareToBuilderV2 {
    private Integer id = -1;
    private Integer age = -1;
    private String firstName = null;
    private String lastName = null;

    public EmployeeCompareToBuilderV2(Integer id, String fName, String lName, Integer age) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
    }
}
