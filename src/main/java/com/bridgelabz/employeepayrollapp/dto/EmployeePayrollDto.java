package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

@Data
public class EmployeePayrollDto {
    public String name;
    public long salary;

    public EmployeePayrollDto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
}
