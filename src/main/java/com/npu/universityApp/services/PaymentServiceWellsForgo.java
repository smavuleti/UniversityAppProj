package com.npu.universityApp.services;

import org.springframework.stereotype.Service;

import com.npu.universityApp.domain.Student;


@Service("paymentServiceWellsForgo")
public class PaymentServiceWellsForgo implements PaymentService {

	public void makePayment(Student student, String creditCardNumber, double amountPaid) {
		// TODO Auto-generated method stub
		System.out.println("Using WellsForgo credit card processor " +creditCardNumber+ "with amount " +amountPaid+ " for "+student.getName());

	}

}
