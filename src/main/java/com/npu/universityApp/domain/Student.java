package com.npu.universityApp.domain;

import java.util.ArrayList;

public class Student {

	//name
	private String name;
	//id
	private int id;
	//student is international or not?
	private boolean studentInternational;
	//student is graduate or undergraduate?
	private String studentLevel;
	//student's course list
	private ArrayList<String> studentCourseList;

	public Student(){
		
	}
	
	//set and get methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isStudentInternational() {
		return studentInternational;
	}
	public void setStudentIsInternational(boolean studentIsInternational) {
		this.studentInternational = studentIsInternational;
	}
	public String getStudentLevel() {
		return studentLevel;
	}
	public void setStudentLevel(String studentLevel) {
		this.studentLevel = studentLevel;
	}
	public ArrayList<String> getStudentCourseList() {
		return studentCourseList;
	}
	public void setStudentCourseList(ArrayList<String> studentCourseList) {
		this.studentCourseList = studentCourseList;
	}  
	
	
	
}
