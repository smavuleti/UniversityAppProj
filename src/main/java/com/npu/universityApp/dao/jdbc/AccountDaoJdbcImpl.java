package com.npu.universityApp.dao.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.npu.universityApp.dao.AccountDao;
import com.npu.universityApp.domain.Account;

@Repository("accountDaoJdbc")
public class AccountDaoJdbcImpl implements AccountDao {

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	private SimpleJdbcInsert simpleJdbcInsert;
	private AccountRowMapper accountRowMapper;

	@PostConstruct
	public void setup() {
		// jdbc template
		jdbcTemplate = new JdbcTemplate(dataSource);
		// NamedParameterJdbcTemplate
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		// accountRowMapper
		accountRowMapper = new AccountRowMapper();
		// SimpleInsertJdbc
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("account");

	}

	public Account createNewAccount(int studentId) {

		String sql = "SELECT * from account where account_id=" + studentId;

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("account_id", studentId);
		params.addValue("account_balance", " 0.00");
		params.addValue("account_date", "2016-11-08");

		// SqlParameterSource paramSource = new
		// BeanPropertySqlParameterSource(object)
		simpleJdbcInsert.execute(params);
		// jdbcTemplate.update(sql,params);
		Account account = namedParamJdbcTemplate.queryForObject(sql, params, accountRowMapper);
		return account;
	}

	public double getBalance(int accountId) {
		// TODO Auto-generated method stub
		String sql = "select account_balance from account where account_id =?";
		return jdbcTemplate.queryForObject(sql, Double.class, accountId);
	}

	public void updateBalance(int accountId, double depositAmount) {
		// TODO Auto-generated method stub
		String sql = "Update account set account_balance=? where account_id = ?";
		jdbcTemplate.update(sql, depositAmount, accountId);
	}

	public ArrayList<Account> overdueAccounts() {
		// TODO Auto-generated method stub
		double overdue = 0.00;
		String sql = "select * from account where account_balance >" + overdue;
		ArrayList<Account> accountList = (ArrayList<Account>) jdbcTemplate.query(sql, accountRowMapper);
		return accountList;
	}

	public int getAccountCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from account";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
