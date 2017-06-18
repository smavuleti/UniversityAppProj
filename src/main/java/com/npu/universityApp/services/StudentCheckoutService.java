package com.npu.universityApp.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.npu.universityApp.dao.AccountDao;
import com.npu.universityApp.domain.Course;
import com.npu.universityApp.domain.Student;
import com.npu.universityApp.exceptions.InvalidCreditCardNumberException;
import com.npu.universityApp.exceptions.PaymentAuthorizationFailedException;

import org.springframework.stereotype.Service;

@Service("studentCheckout")
public class StudentCheckoutService {

	@Autowired
	// @Qualifier("tutionCalculatorServiceOhioImp")
	@Qualifier("tutionCalculatorServiceNationalImp")
	private TutionCalculatorService tutionCalculatorService;
	@Autowired
	@Qualifier("paymentServicePaypal")
	// @Qualifier("paymentServiceWellsForgo")
	private PaymentService paymentSrvc;

	// account
	@Autowired
	@Qualifier("accountDaoJdbc")
	private AccountDao accountDao;

	public StudentCheckoutService() {

	}

	public void setTutionCalculatorService(TutionCalculatorService tutionCalService) {
		this.tutionCalculatorService = tutionCalService;
	}

	public void setPaymentService(PaymentService paymentSrvc) {
		this.paymentSrvc = paymentSrvc;
	}

	// method checkout() that takes a Student object, a list of Course
	// objects,and creditcardnumber
	public void checkout(Student student, ArrayList<Course> courseList, String creditCardNumber, double amountPaid) {
		// System.out.println(courseList.get(0));
		// Register the Student involves adding each Course to the student’s
		// course list and updating the enrollment number for each Course
		for (int count = 0; count < courseList.size(); count++) {
			// System.out.println(count);
			// System.out.println(tutionCalculatorService);
			tutionCalculatorService.computeTution(student, courseList.get(count));
			try {
				paymentSrvc.makePayment(student, creditCardNumber, amountPaid);
				accountDao.updateBalance(student.getId(), amountPaid);
			} catch (InvalidCreditCardNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PaymentAuthorizationFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			courseList.get(count).setStudentCount(courseList.get(count).getStudentCount() + 1);
		}
		System.out.println("Student balance after checkout: " + accountDao.getBalance(student.getId()));
	}

}