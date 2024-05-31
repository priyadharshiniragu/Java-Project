package com.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.jpa.model.EmployeeUser;

public interface EmployeeRepository extends JpaRepository<EmployeeUser, Integer>{

}
