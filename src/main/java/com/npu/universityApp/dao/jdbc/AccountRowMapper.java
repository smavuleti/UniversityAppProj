package com.npu.universityApp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.npu.universityApp.domain.Account;

public class AccountRowMapper implements RowMapper<Account> {

	public Account mapRow(ResultSet resultSet, int row) throws SQLException {
		int accountId;
		double balance;
		Date date;
		Account account;

		accountId = resultSet.getInt("account_id");
		balance = resultSet.getDouble("account_balance");
		date = resultSet.getDate("account_date");
		account = new Account(accountId, balance, date);

		account.setAccountId(resultSet.getInt("account_id"));
		account.setBalanceDue(resultSet.getDouble("account_balance"));
		account.setDueDate(resultSet.getDate("account_date"));
		return account;

	}

}