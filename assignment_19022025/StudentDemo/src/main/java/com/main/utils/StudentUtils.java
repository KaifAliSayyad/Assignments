package com.main.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.main.models.Student;

public class StudentUtils {
	private static List<Student> students = new ArrayList<>();
	
	public static void loadStudents(){
		Random rand = new Random();
        String[] schoolNames = {"GSA", "DPS", "ABC", "XYZ"};
        
        for (int i = 1; i <= 50; i++) {
            int rollNo = i;
            String name = "Student" + i;
            int standard = rand.nextInt(9) + 1; // Random standard between 1-9
            String school = schoolNames[rand.nextInt(schoolNames.length)];
            double percentage = 20 + rand.nextDouble() * (99 - 20); // Random percentage between 20-99
            
            students.add(new Student(rollNo, name, standard, school, percentage));
        }
        
        System.out.println("Students loaded successfully!");
       
	}
	
	public static List<Student> getAllStudents(){
		return students;
	}
	
	public static Student getStudentOnRollNo(int roll) {
		List<Student> s = students.stream().filter((student) -> student.getRollNo() == roll).collect(Collectors.toList());
		return s.size() > 0 ? s.get(0) : null;
	}
	
	public static List<Student> getStudentOnSchoolName(String sch) {
		List<Student> s = students.stream().filter((student) -> student.getSchool().equals(sch)).collect(Collectors.toList());
		return s;
	}
	
	public static List<Student> getStudentOnResult(boolean b) {
		List<Student> s = students.stream().filter((student) -> {
			if(b) {
				return student.getPercentage() >= 40;
			}else {
				return student.getPercentage() < 40;
			}
		}).collect(Collectors.toList());
		return s;
	}
	

	public static long getStudentCountOnStd(int std) {
		Long s = 0l;
		s = students.stream().filter((student) -> student.getStandard() == std).collect(Collectors.counting());
		return s;
	}
	
	public static long getStudentCountOnSchool(String sch) {
		Long s = 0l;
		s = students.stream().filter((student) -> student.getSchool().equals(sch)).collect(Collectors.counting());
		return s;
	}
	
	public static List<Student> getTopFiveStudents(){
		List<Student> s = students.stream().sorted(new StudentPercentageComparator()).limit(5).collect(Collectors.toList());
		return s;
	}
	
	public static Student getTopperOnStd(int std) {
		List<Student> s = students.stream().filter((student) -> student.getStandard() == std).sorted(new StudentPercentageComparator()).limit(1).collect(Collectors.toList());
		return s.size() > 0 ? s.get(0) : null;
	}
}
