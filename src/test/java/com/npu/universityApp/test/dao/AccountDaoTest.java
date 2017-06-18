package com.npu.universityApp.test.dao;

import com.npu.universityApp.dao.AccountDao;
import com.npu.universityApp.dao.jdbc.AccountDaoJdbcImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:universitydao-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountDaoTest {

	@Autowired
	@Qualifier("accountDaoJdbc")
	private AccountDao accountDao;
	// private AccountDaoJdbcImpl accountDaoJdbc;

	@Test
	public void testCreateAccount() {
		int accountCount = accountDao.getAccountCount();

		assertEquals(3, accountCount);
	}

	@Test
	public void testGetAccountBalance() {

		assertEquals(accountDao.getBalance(1), 4.00, 0.00);
	}

	@Test
	public void testUpdateAccount() {
		accountDao.updateBalance(1, 4.00);
		assertEquals(accountDao.getBalance(1), 4.00, 0.00);
	}

	@Test
	public void testOverdueAccounts() {

		assertEquals(accountDao.getAccountCount(), 3);

	}

}
