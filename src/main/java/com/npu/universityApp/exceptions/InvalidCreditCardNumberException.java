package com.npu.universityApp.exceptions;

public class InvalidCreditCardNumberException extends Exception {
	public InvalidCreditCardNumberException(String displayExceptionMessage) {
		super(displayExceptionMessage);
	}

}
