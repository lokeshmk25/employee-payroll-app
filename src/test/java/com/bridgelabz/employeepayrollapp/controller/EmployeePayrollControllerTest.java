package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeePayrollControllerTest {

    @InjectMocks
    private EmployeePayrollController employeePayrollController;
    
    @Mock
    private EmployeePayrollService employeePayrollService;

    @Test
    void givenEmployeeDetails_WhenAdded_ShouldReturnMessage_EqualsToSuccessMessage() {
        String successmessage="Employee payroll data added successfully";
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Lokesh");
        employeePayrollDTO.setSalary(40000);
        when(employeePayrollService.addEmployee(employeePayrollDTO))
                .thenReturn("Employee payroll data added successfully");
        String message = employeePayrollController.setEmployeePayrollData(employeePayrollDTO);
    }
}
