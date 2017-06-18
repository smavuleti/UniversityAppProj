package com.npu.universityApp.dao;

import java.util.ArrayList;

import com.npu.universityApp.domain.Account;

public interface AccountDao {

	// method to create a new Account for a student
	public Account createNewAccount(int studentId);

	// method that given an account id, retrieves the balance
	public double getBalance(int accountId);

	// A method that adds an amount to the current balance -- Given an account
	// id and an amount to add
	public void updateBalance(int accountId, double depositAmount);

	/*
	 * A method that retrieves a list of account ids that have overdue balances
	 * (an overdue balance is one where the balance is greater than 0.00 and the
	 * current date is after the due date
	 */
	public ArrayList<Account> overdueAccounts();
	
	public int getAccountCount();
}
