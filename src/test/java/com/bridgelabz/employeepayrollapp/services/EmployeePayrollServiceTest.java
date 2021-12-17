package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.builder.PayrollBuilder;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Purpose : To run Employee Payroll Test using Mockito
 *
 * @author Lokesh
 * @version 0.0.1-SNAPSHOT
 * @since 14-12-21
 */
@ExtendWith(MockitoExtension.class)
public class EmployeePayrollServiceTest {

    @InjectMocks
    private EmployeePayrollService employeePayrollService;
    @Mock
    private EmployeeRepository repository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private PayrollBuilder payrollBuilder;

    @Test
    void whengetallMethodCalled_ShouldReturnListOfEmployeePayrollDto() {
        List<EmployeePayrollDTO> dtoList = new ArrayList<>();
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Lokesh");
        employeePayrollDTO.setSalary(89000);
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setPhoneNumber("9876543210");
        dtoList.add(employeePayrollDTO);
        EmployeePayrollDTO employeePayrollDTO1 = new EmployeePayrollDTO();
        employeePayrollDTO1.setName("Suresh");
        employeePayrollDTO1.setSalary(56000);
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setPhoneNumber("9876543210");
        dtoList.add(employeePayrollDTO1);

        List<EmployeePayroll> payroll = new ArrayList<>();
        EmployeePayroll employeePayroll = new EmployeePayroll();
        employeePayroll.setName("Lokesh");
        employeePayroll.setSalary(78900);
        employeePayroll.setGender("male");
        employeePayroll.setPhoneNumber("98765432121");
        employeePayroll.setCreatedOn(LocalDateTime.now());
        employeePayroll.setUpdatedOn(LocalDateTime.now());
        payroll.add(employeePayroll);
        EmployeePayroll employeePayroll1 = new EmployeePayroll();
        employeePayroll1.setName("yokesh");
        employeePayroll1.setSalary(89900);
        employeePayroll.setGender("male");
        employeePayroll.setPhoneNumber("98765432121");
        employeePayroll.setCreatedOn(LocalDateTime.now());
        employeePayroll.setUpdatedOn(LocalDateTime.now());
        payroll.add(employeePayroll1);

        when(repository.findAll()).thenReturn(payroll);
        when(modelMapper.map(payroll.get(0), EmployeePayrollDTO.class)).thenReturn(employeePayrollDTO);
        when(modelMapper.map(payroll.get(1), EmployeePayrollDTO.class)).thenReturn(employeePayrollDTO1);
        List<EmployeePayrollDTO> employeePayrollDTOS = employeePayrollService.getAllEmployee();
        Assertions.assertEquals(2, employeePayrollDTOS.size());
        Assertions.assertEquals(dtoList, employeePayrollDTOS);
    }

    @Test
    void givenId_WhenFind_ShouldReturnEmployeeDetails() {
        int id = 1;
        EmployeePayroll employeePayroll = new EmployeePayroll();
        employeePayroll.setName("Lokesh");
        employeePayroll.setSalary(78900);
        employeePayroll.setGender("male");
        employeePayroll.setPhoneNumber("98765432121");
        employeePayroll.setCreatedOn(LocalDateTime.now());
        employeePayroll.setUpdatedOn(LocalDateTime.now());

        when(repository.findById(id)).thenReturn(Optional.of(employeePayroll));
        EmployeePayroll employee = employeePayrollService.findEmployee(id);
        Assertions.assertEquals(employeePayroll, employee);
    }

    @Test
    void whenSetEmployeePayrollDatacalled_ShouldReturnSuccessMessage() {
        String successmessage = "Employee payroll data added successfully";
        EmployeePayroll employeePayroll = new EmployeePayroll();
        employeePayroll.setName("Lokesh");
        employeePayroll.setSalary(78900);
        employeePayroll.setGender("male");
        employeePayroll.setPhoneNumber("98765432121");
        employeePayroll.setCreatedOn(LocalDateTime.now());
        employeePayroll.setUpdatedOn(LocalDateTime.now());

        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Toby");
        employeePayrollDTO.setSalary(22200);
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setPhoneNumber("9876543210");

        when(modelMapper.map(employeePayrollDTO, EmployeePayroll.class)).thenReturn(employeePayroll);

        String message = employeePayrollService.addEmployee(employeePayrollDTO);
        Assertions.assertEquals(successmessage, message);
    }

    @Test
    void whenUpdateAtmCalled_forGivenId_ShouldThrowException() {
        int id = 1;
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Toby");
        employeePayrollDTO.setSalary(22200);
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setPhoneNumber("9876543210");

        when(repository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class,
                () -> employeePayrollService.updateEmployee(id, employeePayrollDTO));
    }

    @Test
    void givenWhenEmployeeDto_UpdateIsCalled_ShouldReturnSuccessmessage() {
        int id = 1;
        ArgumentCaptor<EmployeePayroll> employeePayrollArgumentCaptor = ArgumentCaptor.forClass(EmployeePayroll.class);
        String successmessage = "Employee data updated successfully";
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Toby");
        employeePayrollDTO.setSalary(22200);
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setPhoneNumber("9876543210");

        EmployeePayroll employeePayroll = new EmployeePayroll();
        employeePayroll.setName("Toby");
        employeePayroll.setSalary(22200);
        employeePayroll.setGender("male");
        employeePayroll.setPhoneNumber("98765432121");
        employeePayroll.setCreatedOn(LocalDateTime.now());
        employeePayroll.setUpdatedOn(LocalDateTime.now());

        when(repository.findById(id)).thenReturn(Optional.of(employeePayroll));
        when(payrollBuilder.buildPayrollEntity(employeePayrollDTO, employeePayroll)).thenReturn(employeePayroll);
        String message = employeePayrollService.updateEmployee(id, employeePayrollDTO);
        Mockito.verify(repository, times(1)).save(employeePayrollArgumentCaptor.capture());
        Assertions.assertEquals(successmessage, message);
        Assertions.assertEquals(employeePayrollDTO.getName(), employeePayrollArgumentCaptor.getValue().getName());
        Assertions.assertEquals(employeePayrollDTO.getSalary(), employeePayrollArgumentCaptor.getValue().getSalary());

    }

    @Test
    void givenIdandEmployeeDto_DeleteisCalled_ShouldReturnSuccessMessage() {
        int id = 1;
        String successmessage = "Employee data deleted successfully";
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO();
        employeePayrollDTO.setName("Toby");
        employeePayrollDTO.setSalary(22200);
        employeePayrollDTO.setGender("Male");
        employeePayrollDTO.setPhoneNumber("9876543210");

        EmployeePayroll employeePayroll = new EmployeePayroll();
        employeePayroll.setName("Toby");
        employeePayroll.setSalary(22200);
        employeePayroll.setGender("male");
        employeePayroll.setPhoneNumber("98765432121");
        employeePayroll.setCreatedOn(LocalDateTime.now());
        employeePayroll.setUpdatedOn(LocalDateTime.now());
        when(repository.findById(id)).thenReturn(Optional.of(employeePayroll));
        String message = employeePayrollService.delete(1);
        Assertions.assertEquals(successmessage, message);
    }

}
