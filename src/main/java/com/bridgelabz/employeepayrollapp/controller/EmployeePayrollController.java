package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.entity.ResponseEntity;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose - To implement various HTTP methods
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 08-12-21
 */
@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService payrollService;

    /**
     * Purpose : To create Request mapping
     *
     * @return : Welcome message for employee payroll
     */
    @RequestMapping(value = {"", "/"})
    public String getGreetings() {
        return "Welcome to Employee payroll service";
    }

    /**
     * Purpose : To implement Get mapping method
     *
     * @return : List of all employee saved in database
     */
    @GetMapping("/getall")
    public List<EmployeePayrollDTO> getallEmployee() {
        return payrollService.getAllEmployee();
    }

    /**
     * Purpose : To create employee entity in the database
     *
     * @param employeePayrollDto : Requestbody annotation is used to obtain employeeDTO as input and validating it
     * @return : Custom message provoided by service class
     */
    @PostMapping("/create")
    public ResponseEntity setEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDto) {
        String message = payrollService.addEmployee(employeePayrollDto);
        return new ResponseEntity(message,employeePayrollDto, HttpStatus.OK);
    }

    /**
     * Purpose : To update employee entity already present in database
     *
     * @param id                 : PathVariable annotation is used to take Id from Url
     * @param employeePayrollDto :  Requestbody annotation is used to obtain employeeDTO as input and validating it
     * @return : Custom message provoided by service class
     */
    @PutMapping("/update/{id}")
    public ResponseEntity updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO employeePayrollDto) {
        String message = payrollService.updateEmployee(id, employeePayrollDto);
        return new ResponseEntity(message,employeePayrollDto,HttpStatus.OK);
    }

    /**
     * Purpose : To delete the employeePayroll entity based on Id
     *
     * @param id : Path variable annotation is used to take input from user
     * @return : Custom message provoided by service class
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployeePayrollData(@PathVariable int id) {
        String message = payrollService.delete(id);
        return new ResponseEntity("Id is found",message,HttpStatus.OK);
    }
}
