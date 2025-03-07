package com.main.entities;

import org.hibernate.annotations.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emp")
public class Employee {
	
	@Id
	@Generated
	private int id;
	
	private String name;
	
	private int age;
		
	private float salary;
	
	private String designation;

	public Employee() {}
	
	public Employee(String name, int age, float salary, String designation) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.designation = designation;
	}

	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", designation="
				+ designation + "]";
	}
	
	
}
