package com.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.jpa.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
