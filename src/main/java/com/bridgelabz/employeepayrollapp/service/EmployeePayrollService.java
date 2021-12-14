package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.builder.PayrollBuilder;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeePayrollService {
    private static final String EMPLOYEE_DATA_ADDED_SUCCESSFULLY = "Employee payroll data added successfully";
    private static final String EMPLOYEE_UPDATED_SUCCESSFULLY = "Employee data updated successfully";
    private static final String DELETED_SUCCESSFULLY = "Employee data deleted successfully";

    @Autowired
    private PayrollBuilder payrollBuilder;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeRepository repository;

    public List<EmployeePayrollDTO> getAllEmployee(){
        return repository.findAll()
                .stream()
                .map(employeePayrollData -> {
                    return modelMapper.map(employeePayrollData, EmployeePayrollDTO.class);
                })
                .collect(Collectors.toList());

    }

    public String addEmployee(EmployeePayrollDTO employeePayrollDTO){
        EmployeePayroll employeedata= modelMapper.map(employeePayrollDTO, EmployeePayroll.class);
        repository.save(employeedata);
        return EMPLOYEE_DATA_ADDED_SUCCESSFULLY;

    }

    public EmployeePayroll findEmployee(int id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
   }

    public String updateEmployee(int id,EmployeePayrollDTO employeePayrollDTO){
        EmployeePayroll employee = findEmployee(id);
        EmployeePayroll employeePayroll = payrollBuilder.buildPayrollEntity(employeePayrollDTO, employee);
        repository.save(employeePayroll);
        return EMPLOYEE_UPDATED_SUCCESSFULLY;
    }

    public String delete(int id){
        EmployeePayroll employee = findEmployee(id);
        repository.delete(employee);
        return DELETED_SUCCESSFULLY;
    }

}
