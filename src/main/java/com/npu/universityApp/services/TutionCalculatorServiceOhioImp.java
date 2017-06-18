package com.npu.universityApp.services;

import org.springframework.stereotype.Service;

import com.npu.universityApp.domain.Course;
import com.npu.universityApp.domain.Student;



@Service("tutionCalculatorServiceOhioImp")
public class TutionCalculatorServiceOhioImp implements TutionCalculatorService {

	public void computeTution(Student student, Course course) {
		// TODO Auto-generated method stub
		//For undergraduate students the cost is $100 per course unit; 
		//for graduate students the cost is $120 per course unit
		if(student.getStudentLevel().toString()=="Undergrad Level"){
			course.setCourseUnits(100);
			System.out.println("Registeration for Under Grad level, so the tution cost is $100 per " +course.getCourseName()+" course unit");
		} else if(student.getStudentLevel().toString()=="Grad Level"){
			course.setCourseUnits(120);
			System.out.println("Registeration for Grad level, so the tution cost is $120 per " +course.getCourseName()+" course unit");
		}		
		
		//A 10% purcharge is added to the above cost for international students
		if(student.isStudentInternational()==true){
			System.out.println("10% purchase is added");
		}
	}

}
