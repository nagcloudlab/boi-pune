package com.boi.repository;

import com.boi.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * team: team-1
 */
public class SQLAccountRepository implements AccountRepository {

    private static Logger logger = LoggerFactory.getLogger("boi");


    public SQLAccountRepository() {
        logger.info("SQLAccountRepository initialized.");
    }

    public Account loadAccount(String accountNumber) {
        logger.info("Loading account for account number: " + accountNumber);
        return new Account(accountNumber, "A", 1000.0);
    }

    public void updateAccount(Account account) {
        logger.info("Updating account: " + account);
        //..
    }

}
