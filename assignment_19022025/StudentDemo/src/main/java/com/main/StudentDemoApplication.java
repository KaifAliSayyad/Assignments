package com.main;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.main.utils.StudentUtils;

@SpringBootApplication
public class StudentDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDemoApplication.class, args);
		StudentUtils.loadStudents();
		
	}


}
