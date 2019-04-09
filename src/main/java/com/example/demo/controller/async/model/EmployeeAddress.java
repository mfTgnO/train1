package com.example.demo.controller.async.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeAddress implements Serializable {

    private static final long serialVersionUID = 6784559847743698613L;

    public String streetNo;
    public String houseNo;
    public String zipCode;
}
