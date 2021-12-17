package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Purpose _ To define Employee Payroll data transfer objects and validating it
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 08-12-21
 */
@Data
public class EmployeePayrollDTO {

    @NotNull(message = "Employee Name should not be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}", message = "Employee name is not valid")
    private String name;
    @Min(value = 500, message = "Min salary should be 500")
    private long salary;
    @NotNull(message = "Employee gender Should not be null")
    @Pattern(regexp = "^(?:m|M|male|Male|F|f|female|Female|T|t)$",message = "Enter a valid gender")
    private String gender;
    @NotNull
    @Pattern(regexp = "^[986]{1}[0-9]{9}$", message = "Phone Number should contain 10 digits" +
            " and start with either 9,8 or 6")
    private String phoneNumber;

}
