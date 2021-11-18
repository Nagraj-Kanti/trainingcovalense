package com.cov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cov.beans.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
