package com.main.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.models.Student;
import com.main.utils.StudentUtils;

@RestController
public class StudentController {
	
//	@GetMapping("/loadStudents")
//	public void loadStudents() {
//		StudentUtils.loadStudents();
//	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return StudentUtils.getAllStudents();
	}
	
	@GetMapping("/student/{rollNo}")
	public Student getStudentOnRollNo(@PathVariable int rollNo) {
		return StudentUtils.getStudentOnRollNo(rollNo);
	}
	
	@GetMapping("/students/school")
	public List<Student> getStudentsOnSchool(@RequestParam String name){
		return StudentUtils.getStudentOnSchoolName(name);
	}
	
	@GetMapping("/students/result")
	public List<Student> getStudentsResult(@RequestParam boolean pass){
		return StudentUtils.getStudentOnResult(pass);
	}
	
	@GetMapping("/students/{std}/count")
	public Long getStudentCountOnStd(@PathVariable int std) {
		return StudentUtils.getStudentCountOnStd(std);
	}
	
	@GetMapping("/students/strength")
	public Long getStudentCountOnSchool(@RequestParam String school) {
		return StudentUtils.getStudentCountOnSchool(school);
	}
	
	@GetMapping("/students/toppers")
	public List<Student> getToppers(){
		return StudentUtils.getTopFiveStudents();
	}
	
	@GetMapping("students/topper/{std}")
	public Student getTopperFromStd(@PathVariable int std) {
		return StudentUtils.getTopperOnStd(std);
	}
}
