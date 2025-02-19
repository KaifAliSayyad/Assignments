package com.main.models;


public class Student{
	private int rollNo;
	private String name;
	private int standard;
	private String school;
	private double percentage;
	public Student(int rollNo, String name, int standard, String school, double percentage) {
		super();
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
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", standard=" + standard + ", school=" + school
				+ ", percentage=" + percentage + "]";
	}
}

	
