package com.npu.universityApp.test.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.npu.universityApp.domain.Student;
import com.npu.universityApp.exceptions.InvalidCreditCardNumberException;
import com.npu.universityApp.exceptions.PaymentAuthorizationFailedException;
import com.npu.universityApp.services.PaymentService;

@ContextConfiguration("classpath:universitydao-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentServiceTest {

	@Autowired
	@Qualifier("paymentServicePaypal")
	private PaymentService paymentServ;
	private Student std;

	@Test(expected = InvalidCreditCardNumberException.class)
	public void testMakePaymentInvalidCreditCardNumber() throws Exception {
		std = new Student();
		std.setId(123);
		std.setName("Smith");
		std.setStudentIsInternational(false);
		std.setStudentLevel("Grad Level");
		String creditCardNumber = "123456222227890123456";
		paymentServ.makePayment(std, creditCardNumber, 1.0);

	}

	@Test(expected = PaymentAuthorizationFailedException.class)
	public void testMakePaymentAuthorization() throws Exception {
		std = new Student();
		std.setId(123);
		std.setName("Smith");
		std.setStudentIsInternational(false);
		std.setStudentLevel("Grad Level");
		String creditCardNumber = "512345";
		paymentServ.makePayment(std, creditCardNumber, 1.0);
	}

	@Test
	public void testPaymentSuccess() throws Exception {
		std = new Student();
		std.setId(123);
		std.setName("John");
		std.setStudentIsInternational(false);
		std.setStudentLevel("Grad Level");
		String creditCardNumber = "12345";
		paymentServ.makePayment(std, creditCardNumber, 1.0);

	}

}
