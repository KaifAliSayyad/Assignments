package com.main.utils;

import java.util.Comparator;
import com.main.models.Student;

public class StudentPercentageComparator implements Comparator<Student>{
	public int compare(Student e1, Student e2){
		return Double.compare(e2.getPercentage(), e1.getPercentage());
	}
}