package com.bridgelabz.employeepayrollapp.builder;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Purpose - To build Employee payroll application
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 08-12-21
 */
@Component
public class PayrollBuilder {
    @Autowired
    private ModelMapper modelMapper;

    /**
     * purpose - To build employee entity from DTO using model mapper
     *
     * @param payrollDto      : payrollDto is taken as input for conversion
     * @param employeePayroll : employeePayroll entity is also taken as input for mapping
     * @return : It returns converted employee payroll entity
     */
    public EmployeePayroll buildPayrollEntity(EmployeePayrollDTO payrollDto, EmployeePayroll employeePayroll) {
        modelMapper.map(payrollDto, employeePayroll);
        return employeePayroll;
    }
}
