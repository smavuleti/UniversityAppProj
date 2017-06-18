package com.npu.universityApp.services;

import com.npu.universityApp.domain.Course;
import com.npu.universityApp.domain.Student;


public interface TutionCalculatorService {
	public void computeTution(Student student, Course course);

}
