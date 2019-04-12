package com.example.demo.async.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EmployeePhone implements Serializable {

    private static final long serialVersionUID = 1407601086021976259L;
    public List<String> phoneNumbers;
}
