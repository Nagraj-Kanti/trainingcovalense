package com.cov.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cov.beans.Department;
import com.cov.repository.DepartmentRepository;

@TestInstance(Lifecycle.PER_CLASS)
class DepartmentServiceTest {
	@InjectMocks
	DepartmentService departmentService;
	@Mock
	DepartmentRepository departmentRepository;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
		List<Department> departments = new ArrayList<>();
		departments.add(new Department(1, "sales"));
		departments.add(new Department(2, "integrations"));
		departments.add(new Department(3, "mangement"));
		departments.add(new Department(4, "BRM"));
		when(departmentRepository.findAll()).thenReturn(departments);
		Department departmentExisting = new Department(2, "integrations");
		when(departmentRepository.findById(2)).thenReturn(Optional.of(departmentExisting));
	}

	@Test
	void testFindAll() {

		List<Department> perList = departmentService.findAll();
		assertNotNull(perList);
		assertEquals(4, perList.size());
	}

	@Test
	void testFindById() {
//Person personExisting = new Person(2, "Nagraj", "K");
//when(personRepo.findById(2)).thenReturn(Optional.of(personExisting));
		Department department = departmentRepository.findById(2).get();
		assertNotNull(department);
		assertSame(department.getName(), "integrations");

		assertEquals(department.getId(), 2);
	}

	@Test
	void testSave() {
		Department department = new Department(5, "CRM");
		when(departmentRepository.save(department)).thenReturn(department);
		Department d = departmentRepository.save(department);
		assertNotNull(d);
		assertSame(d.getName(), "CRM");
		assertEquals(d.getId(), 5);
	}

	@Test
	void testUpdate() {
		Department department = new Department(4, "BRM");
		when((departmentRepository.findById(department.getId()))).thenReturn(Optional.of(department));
		when(departmentRepository.save(department)).thenReturn(department);
		Department d = departmentRepository.save(department);
		assertNotNull(d);
		assertSame(d.getName(), "BRM");
		assertEquals(d.getId(), 4);
	}

}