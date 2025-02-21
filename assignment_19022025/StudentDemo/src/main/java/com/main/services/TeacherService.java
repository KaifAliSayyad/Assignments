package com.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entities.Teacher;
import com.main.repos.TeacherDAO;


@Service
public class TeacherService {
	
	@Autowired
	private TeacherDAO dao;
	
	public List<Teacher> getAllTeachers(){
		return dao.findAll();
	}
	
	public Optional<Teacher> getByStandard(int standard) {
		return dao.findById(standard);
	}
	
	public String addTeacher(Teacher t) {
		if(!dao.findById(t.getStandard()).isPresent()) {
			dao.save(t);
			return "Teacher added successfully";
		}else {
			return "Teacher already assigned";
		}
	}
}
