package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        Employee employee=null;
        employee=new Employee(1,new EmployeePayrollDto("lokesh",3000));
        ResponseDTO responseDTO=new ResponseDTO("Get call Sucess",employee);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable int id) {
        Employee employee=null;
        employee=new Employee(id,new EmployeePayrollDto("lokesh",3000));
        ResponseDTO responseDTO=new ResponseDTO("Get call for Id Sucess",employee);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> setEmployeePayrollData(@RequestBody EmployeePayrollDto employeePayrollDto) {
        Employee employee=null;
        employee=new Employee(1,employeePayrollDto);
        ResponseDTO responseDTO=new ResponseDTO("Created employee  for Id Sucess",employee);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable int id,@RequestBody EmployeePayrollDto employeePayrollDto) {
        Employee employee=null;
        employee=new Employee(id,employeePayrollDto);
        ResponseDTO responseDTO=new ResponseDTO("Updated employee for Id Sucess",employee);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable int id) {
        ResponseDTO responseDTO=new ResponseDTO("Updated employee for Id Sucess",id);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

}
