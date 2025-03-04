package com.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entities.Employee;
import com.main.repos.EmployeeDAO;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO dao;
	
	public void addEmployee(Employee emp) {
		dao.save(emp);
	}
	
	public void removeEmployee(Employee emp) {
		dao.delete(emp);
	}
	
	public Employee getEmployeeByName(String name) {
		return dao.getByName(name);
	}
	
	public boolean updateEmployee(Employee emp) {
		if(dao.existsById(emp.getId())) {
			dao.save(emp);
			return true;			//Employee updated
		}else {
			dao.save(emp);
			return false;			//Employee added
		}
	}
	
	public List<Employee> getEmployees(){
		return dao.findAll();
	}
	
	public Optional<Employee> getEmployeeByID(int id) {
		return dao.findById(id);
	}
}
