package com.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.models.Student;
import com.main.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/student/{rollNo}")
	public Student getStudentOnRollNo(@PathVariable int rollNo) {
		return studentService.getStudentOnRollNo(rollNo);
	}
	
	@GetMapping("/students/school")
	public List<Student> getStudentsOnSchool(@RequestParam String name){
		return studentService.getStudentOnSchoolName(name);
	}
	
	@GetMapping("/students/result")
	public List<Student> getStudentsResult(@RequestParam boolean pass){
		return studentService.getStudentOnResult(pass);
	}
	
	@GetMapping("/students/{std}/count")
	public Long getStudentCountOnStd(@PathVariable int std) {
		return studentService.getStudentCountOnStd(std);
	}
	
	@GetMapping("/students/strength")
	public Long getStudentCountOnSchool(@RequestParam String name) {
		return studentService.getStudentCountOnSchool(name);
	}
	
	@GetMapping("/students/toppers")
	public List<Student> getToppers(){
		return studentService.getTopFiveStudents();
	}
	
	@GetMapping("students/topper/{std}")
	public Student getTopperFromStd(@PathVariable int std) {
		return studentService.getTopperOnStd(std);
	}
	
	@PostMapping("/students")
	public String saveStudent(@RequestBody Student s) {
		studentService.addStudent(s);
		return "Student Added Successfully";
	}
}
