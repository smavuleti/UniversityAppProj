package com.npu.universityApp.services;

import org.springframework.stereotype.Service;

import com.npu.universityApp.domain.Course;
import com.npu.universityApp.domain.Student;



@Service("tutionCalculatorServiceNationalImp")
public class TutionCalculatorServiceNationalImp implements TutionCalculatorService{

	public void computeTution(Student student, Course course) {
		// TODO Auto-generated method stub
		//For international students the cost is $500 per course unit;
		//for other students the cost is $230 per course unit
		if(student.isStudentInternational()){
			course.setCourseUnits(500);
			System.out.println("Student is international, So $500 per unit for " +course.getCourseName());
		} else {
			course.setCourseUnits(230);
			System.out.println("Student is local, So $230 per unit for " +course.getCourseName());
		}
	}

}
