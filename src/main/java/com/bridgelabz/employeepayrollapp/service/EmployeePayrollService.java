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

/**
 * Purpose : To implement various HTTP methods
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 08-12-21
 */
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

    /**
     * Purpose : To get the list of all employee present in Repository
     *
     * @return : List of employeeDto present in repository
     */
    public List<EmployeePayrollDTO> getAllEmployee() {
        return repository.findAll()
                .stream()
                .map(employeePayrollData -> {
                    return modelMapper.map(employeePayrollData, EmployeePayrollDTO.class);
                })
                .collect(Collectors.toList());

    }

    /**
     * Purpose : To add Employee Entity in Repository by conveting EmployeeDTO to Employee entity
     *
     * @param employeePayrollDTO : EmployeeDTO is taken as input and converted using model mapper
     * @return : Custom message provided in method
     */
    public String addEmployee(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayroll employeedata = modelMapper.map(employeePayrollDTO, EmployeePayroll.class);
        repository.save(employeedata);
        return EMPLOYEE_DATA_ADDED_SUCCESSFULLY;

    }

    /**
     * Purpose : To find the given Id is Present or not in the repository
     *
     * @param id : Id is taken as input for searching
     * @return : Id found in repository else Throw Exception
     */
    public EmployeePayroll findEmployee(int id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    /**
     * Purpose : To Update Employee entity Present in repository using Id
     *
     * @param id                 : Id is taken as input for searching in repository
     * @param employeePayrollDTO : EmployeeDto is taken as input to update the entity
     * @return : Custom message provide by the method
     */
    public String updateEmployee(int id, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayroll employee = findEmployee(id);
        EmployeePayroll employeePayroll = payrollBuilder.buildPayrollEntity(employeePayrollDTO, employee);
        repository.save(employeePayroll);
        return EMPLOYEE_UPDATED_SUCCESSFULLY;
    }

    /**
     * Purpose : To delete employeeEntity from repository using Id
     *
     * @param id : Id is taken as input to find entity from repository
     * @return : Custom message provide by the method
     */
    public String delete(int id) {
        EmployeePayroll employee = findEmployee(id);
        repository.delete(employee);
        return DELETED_SUCCESSFULLY;
    }

}
