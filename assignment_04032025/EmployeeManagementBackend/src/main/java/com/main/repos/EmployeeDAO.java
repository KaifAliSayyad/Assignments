package com.main.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entities.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
	public Employee getByName(String name);
}
