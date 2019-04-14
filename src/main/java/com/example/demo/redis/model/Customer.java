package com.example.demo.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID = -6894784201567109845L;
    private long id;
    private String firstName;
    private String lastName;
}
