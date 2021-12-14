package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService payrollService;

    @RequestMapping(value = {"", "/"})
    public String getEmployeePayrollData() {
        return "Welcome to Employee payroll service";
    }

    @GetMapping("/getall")
    public List<EmployeePayrollDTO> getallEmployee() {
        return payrollService.getAllEmployee();
    }

    @PostMapping("/create")
    public String setEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDto) {
       return payrollService.addEmployee(employeePayrollDto);
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id,@RequestBody EmployeePayrollDTO employeePayrollDto) {
        return payrollService.updateEmployee(id,employeePayrollDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeePayrollData(@PathVariable int id) {
       return payrollService.delete(id);
    }

}
