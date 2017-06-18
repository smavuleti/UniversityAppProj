package com.npu.universityApp.domain;

import java.util.Date;

public class Account {

	private int accountId;
	private double balanceDue;
	private Date dueDate;
	
	public Account(int accountId, double balanceDue, Date dueDate){
		this.accountId = accountId;
		this.balanceDue = balanceDue;
		this.dueDate = dueDate;
	}
	
	
	public long getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public double getBalanceDue() {
		return balanceDue;
	}
	public void setBalanceDue(double balanceDue) {
		this.balanceDue = balanceDue;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
}
