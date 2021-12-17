package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.entity.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose - Interface employee repository that extends Jpa repository is used as local data base
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 08-12-21
 */
public interface EmployeeRepository extends JpaRepository<EmployeePayroll, Integer> {
}
