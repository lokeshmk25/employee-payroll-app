package com.bridgelabz.employeepayrollapp.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Purpose - To define entities of employee payroll
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 08-12-21
 */
@Getter
@Setter
@Entity
@Table(name = "employee_payroll_service")
public class EmployeePayroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_ID")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Salary")
    private long salary;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Phone_number")
    private String phoneNumber;
    @CreationTimestamp
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @UpdateTimestamp
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;


}
