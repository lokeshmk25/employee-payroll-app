package com.bridgelabz.employeepayrollapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Purpose - To simulate Employee payroll application
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 08-12-21
 */
@SpringBootApplication
@EnableEncryptableProperties
@Slf4j
public class EmployeePayrollApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(EmployeePayrollApp.class, args);
        log.info("Employee Payroll started");
    }

}

