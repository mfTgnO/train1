package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mango
 */
@Data
@AllArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = -6894784201567109845L;

    private Long id;

    private String firstName;

    private String lastName;
}
