package com.bridgelabz.employeepayrollapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableEncryptableProperties
@Slf4j
public class EmployeePayrollApp {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(EmployeePayrollApp.class, args);
		log.info("Employee Payroll started");
	}
}
