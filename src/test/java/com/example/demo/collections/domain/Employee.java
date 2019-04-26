package com.example.demo.collections.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Package: com.example.demo.collections.domain
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-26 18:48
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = 2620230732871115290L;
    private Integer id;
    private String firstName;
    private String lastName;
    private Department department;
}
