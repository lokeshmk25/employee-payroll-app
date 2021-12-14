package com.bridgelabz.employeepayrollapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name="payroll_service")
public class EmployeePayroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    @NotNull

    private String name;
    private long salary;

}
