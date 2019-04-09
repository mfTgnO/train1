package com.example.demo.controller.async.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeName implements Serializable {

    private static final long serialVersionUID = -5782901374573219751L;

    private String firstName;
    private String lastName;
}
