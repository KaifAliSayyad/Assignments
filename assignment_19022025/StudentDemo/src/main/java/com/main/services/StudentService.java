package com.main.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entities.Student;
import com.main.entities.Teacher;
import com.main.repos.StudentDAO;


@Service
public class StudentService {
	
	@Autowired
	private StudentDAO dao;
	
	
	
	public List<Student> getAllStudents(){
		return dao.findAll();
	}
	
	public Student getStudentOnRollNo(int roll) {
		return dao.getByRollNo(roll);
	}
	
	public List<Student> getStudentOnSchoolName(String sch) {
		return dao.getBySchool(sch);
	}
	
	public List<Student> getStudentOnResult(boolean b) {
		if(b) {
			return dao.findByPercentageGreaterThan(39d);
		}else {
			return dao.findByPercentageLessThan(40d);
		}
	}
	

	public long getStudentCountOnStd(int std) {
		return dao.getByStandard(std).size();
	}
	
	public long getStudentCountOnSchool(String sch) {
		return dao.getBySchool(sch).size();
	}
	
	public List<Student> getTopFiveStudents(){
		return dao.getTopFive();
	}
	
	public Student getTopperOnStd(int std) {
		List<Student> l =  dao.findByStandardOrderByPercentageDesc(std);
		return l.size() > 0 ? l.get(0) : null;
	}
	
	public Student addStudent(Student s) {
		List<Student> fromDb = getAllStudents().stream().filter(student -> student.getSchool().equals(s.getSchool())).toList();
		List<Student> fromDbStudent = fromDb.stream().filter(student -> student.getRollNo() == s.getRollNo()).toList();
		if(fromDbStudent.size() == 0) {
			return dao.save(s);
		}else {
			return null;
		}
	}
	
	public Optional<Teacher> getByRegNo(int regNo) {
		Optional<Student> s = dao.findById(regNo);
		if(!s.isPresent()) return null;
		int std = s.get().getStandard();
		return new TeacherService().getByStandard(std);
	}
}
