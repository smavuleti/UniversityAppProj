package com.npu.universityApp.client;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.npu.universityApp.domain.Course;
import com.npu.universityApp.domain.Student;
import com.npu.universityApp.exceptions.InvalidCreditCardNumberException;
import com.npu.universityApp.exceptions.PaymentAuthorizationFailedException;
import com.npu.universityApp.services.StudentCheckoutService;


public class UniversityApplication {
	public static void main(String args[]) throws InvalidCreditCardNumberException, PaymentAuthorizationFailedException {
		AbstractApplicationContext container = new ClassPathXmlApplicationContext("service.xml");
		StudentCheckoutService studentCheckout = (StudentCheckoutService) container.getBean("studentCheckout");

		Student studentObj1 = new Student();
		ArrayList<Course> courseObj1 = new ArrayList<Course>();
		String creditCardNumber = "123455987";
		double amount = 8.00;
		studentCheckout.checkout(createStudent(studentObj1), createCourse(courseObj1), creditCardNumber,amount);

	}

	public static Student createStudent(Student studentObject) {
		studentObject.setId(2);
		studentObject.setName("John Smith");
		studentObject.setStudentIsInternational(false);
		studentObject.setStudentLevel("Grad Level");

		return studentObject;
	}

	public static ArrayList<Course> createCourse(ArrayList<Course> courseObject) {
		Course course1, course2;
		course1 = new Course("CS480");
		courseObject.add(course1);

		course2 = new Course("CS570");
		courseObject.add(course2);

		return courseObject;
	}
}
