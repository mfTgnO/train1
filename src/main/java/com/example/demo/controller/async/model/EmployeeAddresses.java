package com.example.demo.controller.async.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EmployeeAddresses implements Serializable {

    private static final long serialVersionUID = -8669289328654952147L;
    public List<EmployeeAddress> employeeAddressList;
}
