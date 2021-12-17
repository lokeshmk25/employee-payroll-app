package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.entity.ResponseEntity;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Purpose : To Run Employee Payroll Controller Test
 *
 * @author Lokesh
 * @version 0.0.1-SNAPSHOT
 * @since 14-12-21
 */
@ExtendWith(MockitoExtension.class)
public class EmployeePayrollControllerTest {

    @InjectMocks
    private EmployeePayrollController employeePayrollController;

    @Mock
    private EmployeePayrollService employeePayrollService;

    @Test
    void givenEmployeeDetails_WhenAdded_ShouldReturnMessage_EqualsToSuccessMessage() {
        String successmessage = "Employee payroll data added successfully";
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Lokesh");
        employeePayrollDTO.setSalary(40000);
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setPhoneNumber("9876543210");
        when(employeePayrollService.addEmployee(employeePayrollDTO))
                .thenReturn("Employee payroll data added successfully");
        ResponseEntity responseEntity = employeePayrollController.setEmployeePayrollData(employeePayrollDTO);
        assertEquals(successmessage, responseEntity.getMessage());
    }

    @Test
    void givenEmployeeDetails_WhenGetEmployeeDetails_ThenShouldReturnListOfEmployeeDetails() {
        List<EmployeePayrollDTO> employeepayroll = new ArrayList<>();
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Lokesh");
        employeePayrollDTO.setSalary(40000);
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setPhoneNumber("9876543201");
        employeePayrollService.addEmployee(employeePayrollDTO);
        employeepayroll.add(employeePayrollDTO);
        EmployeePayrollDTO employeePayrollDTO1 = new EmployeePayrollDTO();
        employeePayrollDTO1.setName("Madara");
        employeePayrollDTO1.setSalary(40000);
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setPhoneNumber("9876543210");
        employeePayrollService.addEmployee(employeePayrollDTO1);
        employeepayroll.add(employeePayrollDTO1);
        when(employeePayrollService.getAllEmployee())
                .thenReturn(employeepayroll);
        List<EmployeePayrollDTO> payrollDTOList = employeePayrollController.getallEmployee();
        Assertions.assertEquals(employeepayroll.size(), payrollDTOList.size());
    }

    @Test
    void givenEmployeeDetails_WhenUpdated_ShouldReturnSuccessMessage() {
        String successmessage = "Employee data updated successfully";
        int id = 1;
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Lokesh");
        employeePayrollDTO.setSalary(40000);
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setPhoneNumber("9876543210");
        when(employeePayrollService.updateEmployee(id, employeePayrollDTO))
                .thenReturn(successmessage);
        ResponseEntity responseEntity = employeePayrollController.updateEmployee(id, employeePayrollDTO);
        Assertions.assertEquals(successmessage, responseEntity.getMessage());
    }

    @Test
    void givenEmployeeDetails_WhenDeleted_ShouldReturnSuccessMessage() {
        String successmessage = "Id is found";
        int id = 1;
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Lokesh");
        employeePayrollDTO.setSalary(40000);
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setPhoneNumber("9876543210");
        when(employeePayrollService.delete(id))
                .thenReturn(successmessage);
        ResponseEntity responseEntity = employeePayrollController.deleteEmployeePayrollData(id);
        Assertions.assertEquals(successmessage, responseEntity.getMessage());
    }
}
