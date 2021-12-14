package com.bridgelabz.employeepayrollapp.builder;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayrollBuilder {
    @Autowired
    private ModelMapper modelMapper;

    public EmployeePayroll buildPayrollEntity(EmployeePayrollDTO payrollDto, EmployeePayroll employeePayroll) {
        modelMapper.map(payrollDto, employeePayroll);
        return employeePayroll;
    }
}
