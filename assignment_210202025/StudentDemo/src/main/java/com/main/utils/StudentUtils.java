package com.main.utils;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.models.Student;
import com.main.repos.StudentDAO;

@Service
public class StudentUtils {
	
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
		return dao.findByStandardOrderByPercentageDesc(std).get(0);
	}
}
