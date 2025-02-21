package com.main.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student{
	
	@Id
	private int uniRegNo;
	
	private int rollNo;
	private String name;
	private int standard;
	private String school;
	private double percentage;
	
	public Student() {
		
	}
	
	public Student(int uni_reg_no, int rollNo, String name, int standard, String school, double percentage) {
		super();
		this.uniRegNo = uni_reg_no;
		this.rollNo = rollNo;
		this.name = name;
		this.standard = standard;
		this.school = school;
		this.percentage = percentage;
	}
	
	
	
	public int getRollNo() {
		return rollNo;
	}


	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getStandard() {
		return standard;
	}


	public void setStandard(int standard) {
		this.standard = standard;
	}


	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}


	public double getPercentage() {
		return percentage;
	}


	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}


	public int getUniRegNo() {
		return uniRegNo;
	}
	
	public void setUniRegNo(int uniRegNo) {
		this.uniRegNo = uniRegNo;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", standard=" + standard + ", school=" + school
				+ ", percentage=" + percentage + "]";
	}
}

	
