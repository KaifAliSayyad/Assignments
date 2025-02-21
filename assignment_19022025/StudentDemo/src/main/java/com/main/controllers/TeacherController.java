package com.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entities.Teacher;
import com.main.services.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/teachers")
	public List<Teacher> getTeachers(){
		return teacherService.getAllTeachers();
	}
	
	@PostMapping("/teachers")
	public String addTeacher(@RequestBody Teacher t) {
		return teacherService.addTeacher(t);
	}
}
