package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>("Get call success", HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable int id) {
        return new ResponseEntity<String>("Get call success for id " +id, HttpStatus.OK);
    }
    @PutMapping("/create")
    public ResponseEntity<String> setEmployeePayrollData(@RequestBody EmployeePayrollDto employeePayrollDto) {
        return new ResponseEntity<String>("created employee payroll for " +employeePayrollDto, HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDto employeePayrollDto) {
        return new ResponseEntity<String>("updated employee payroll for " +employeePayrollDto, HttpStatus.OK);
    }
    @DeleteMapping("/get/{id}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable int id) {
        return new ResponseEntity<String>("Delete call success for  id " +id, HttpStatus.OK);
    }

}
