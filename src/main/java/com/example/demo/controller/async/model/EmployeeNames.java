package com.example.demo.controller.async.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class EmployeeNames implements Serializable {

    private static final long serialVersionUID = 6550505549801404170L;
    private List<EmployeeName> employeeNameList;
}
