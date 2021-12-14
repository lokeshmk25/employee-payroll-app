package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class EmployeePayrollDTO {
    @NotNull(message = "Employee Name should not be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}",message = "Employee name is not valid")
    public String name;
    @Min(value =500,message = "Min salary should be 500")
    public long salary;

//    public EmployeePayrollDTO() {
//    }
//
//    public EmployeePayrollDTO(String name, long salary) {
//        this.name = name;
//        this.salary = salary;
//    }
}
