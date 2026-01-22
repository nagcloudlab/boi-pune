package com.boi.repository;

import com.boi.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

/**
 * team: team-1
 */
@Component("sqlAccountRepository")
public class SQLAccountRepository implements AccountRepository {

    private static Logger logger = LoggerFactory.getLogger("boi");

    private DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    @Autowired
    public SQLAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        logger.info("SQLAccountRepository initialized.");
    }

    public Account loadAccount(String accountNumber) {
        logger.info("Loading account for account number: " + accountNumber);
        //..
        String sql = "SELECT account_number, account_holder_name, balance FROM accounts WHERE account_number = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            String accNum = String.valueOf(rs.getString("account_number"));
            String accHolderName = rs.getString("account_holder_name");
            double balance = rs.getDouble("balance");
            return new Account(accNum, accHolderName, balance);
        }, Integer.parseInt(accountNumber));
    }

    public void updateAccount(Account account) {
        logger.info("Updating account: " + account);
        //..
        String sql = "UPDATE accounts SET account_holder_name = ?, balance = ? WHERE account_number = ?";
        jdbcTemplate.update(sql, account.getAccountHolderName(), account.getBalance(), Integer.parseInt(account.getAccountNumber()));
    }

}
