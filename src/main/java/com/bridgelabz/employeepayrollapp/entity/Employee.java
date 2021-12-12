package com.bridgelabz.employeepayrollapp.entity;


import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employee_payroll")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private long salary;

    public Employee() {
    }

    public Employee(int id, EmployeePayrollDto employeePayrollDto) {
        this.id = id;
        this.name = employeePayrollDto.name;
        this.salary = employeePayrollDto.salary;
    }

}
