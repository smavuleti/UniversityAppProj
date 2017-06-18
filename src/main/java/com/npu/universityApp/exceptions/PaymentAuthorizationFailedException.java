package com.npu.universityApp.exceptions;

public class PaymentAuthorizationFailedException extends Exception {
	public PaymentAuthorizationFailedException(String displayExceptionMessage) {
		super(displayExceptionMessage);
	}


}
