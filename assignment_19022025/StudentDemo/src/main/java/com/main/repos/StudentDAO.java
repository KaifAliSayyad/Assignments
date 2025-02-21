package com.main.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.entities.Student;

public interface StudentDAO extends JpaRepository<Student, Integer>{
	
	public Student getByRollNo(int roll);
	public List<Student> getBySchool(String sch);
	public List<Student> findByPercentageGreaterThan(Double percentage);
	public List<Student> findByPercentageLessThan(Double percentage);
	public List<Student> getByStandard(int std);
	
	@Query("from Student order by percentage desc limit 5")
	public List<Student> getTopFive();
	
	public List<Student> findByStandardOrderByPercentageDesc(int std);
	
	
	

}
