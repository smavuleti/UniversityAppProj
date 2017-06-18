package com.npu.universityApp.services;

import com.npu.universityApp.domain.Student;
import com.npu.universityApp.exceptions.InvalidCreditCardNumberException;
import com.npu.universityApp.exceptions.PaymentAuthorizationFailedException;

public interface PaymentService {
	public void makePayment(Student student, String creditCardNumber, double amountPaid) throws InvalidCreditCardNumberException, PaymentAuthorizationFailedException;

}
