package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeePayroll, Integer> {
}
