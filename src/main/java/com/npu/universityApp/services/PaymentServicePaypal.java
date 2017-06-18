package com.npu.universityApp.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npu.universityApp.dao.AccountDao;
import com.npu.universityApp.domain.Student;
import com.npu.universityApp.exceptions.InvalidCreditCardNumberException;
import com.npu.universityApp.exceptions.PaymentAuthorizationFailedException;

@Service("paymentServicePaypal")
public class PaymentServicePaypal implements PaymentService {
	@Autowired
	private AccountDao accountDao;
	private static Logger logger = Logger.getLogger(PaymentServicePaypal.class);

	public void makePayment(Student student, String creditCardNumber, double amountPaid)
			throws InvalidCreditCardNumberException, PaymentAuthorizationFailedException {
		/*
		 * Invalid credit card number. If the credit card number is not 15
		 * digits or contains something other than a digit then throw an
		 * Exception
		 */
		accountDao.createNewAccount(student.getId());
		if (creditCardNumber.length() > 15) {
			System.out.println(creditCardNumber.length());
			throw new InvalidCreditCardNumberException(creditCardNumber + "is not valid");
		}
		int firstDigit = Integer.parseInt(creditCardNumber.substring(0, 1));
		if (firstDigit == 5) {
			throw new PaymentAuthorizationFailedException(
					"This " + creditCardNumber + " failed to authorize, please try other credit card");
		}

		// If payment is successful, update the student’s account balance
		accountDao.updateBalance(student.getId(), amountPaid);
		logger.debug("payment service with credit card number:" + creditCardNumber);
		System.out.println("Using PayPal credit card to " + creditCardNumber + "with amount " + amountPaid + " for "
				+ student.getName() + " is success");

	}

}
