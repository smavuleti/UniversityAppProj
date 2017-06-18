package com.npu.universityApp.domain;

public class Course {
	
	//course name
	private String courseName;
	//department name
	private String departmentName;
	//graduate or undergraduate course?
	private String courseLevel;
	//n.of units
	private int courseUnits;
	//n.of students
	private int studentCount;
	
	public Course(String newCourse){
		courseName = newCourse;
	}

	//set and get methods
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getCourseLevel() {
		return courseLevel;
	}
	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}
	public int getCourseUnits() {
		return courseUnits;
	}
	public void setCourseUnits(int courseUnits) {
		this.courseUnits = courseUnits;
	}
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	
}
