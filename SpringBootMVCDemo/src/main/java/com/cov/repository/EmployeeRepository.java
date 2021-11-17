package com.cov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cov.beans.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
