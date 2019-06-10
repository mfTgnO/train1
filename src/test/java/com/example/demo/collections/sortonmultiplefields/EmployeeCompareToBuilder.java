package com.example.demo.collections.sortonmultiplefields;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 * @package: com.example.demo.collections.sortonmultiplefields
 * @author:
 * @email:
 * @createDate: 2019-06-10 13:21
 * @description:
 */
@Getter
@Setter
@ToString
public class EmployeeCompareToBuilder implements Comparable<EmployeeCompareToBuilder> {
    private Integer id = -1;
    private Integer age = -1;
    private String firstName = null;
    private String lastName = null;

    public EmployeeCompareToBuilder(Integer id, String fName, String lName, Integer age) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
    }

    @Override
    public int compareTo(EmployeeCompareToBuilder o) {
        if (o == null) {
            return -1;
        }
        CompareToBuilder builder = new CompareToBuilder();
        return builder.append(this.getFirstName(), o.getFirstName())
                .append(this.getLastName(), o.getLastName())
                .append(this.getAge(), o.getAge())
                .toComparison();
    }
}
