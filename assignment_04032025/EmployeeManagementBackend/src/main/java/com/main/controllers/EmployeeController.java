package com.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entities.Employee;
import com.main.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return empService.getEmployees();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/employees/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return empService.getEmployeeByName(name);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee emp) {
		empService.addEmployee(emp);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/employees/{name}")
	public void deleteEmployee(@PathVariable String name) {
		empService.removeEmployee(name);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/employees/getMaxId")
	public Integer getMaxID() {
		return empService.getMaxID();
	}
	
}

