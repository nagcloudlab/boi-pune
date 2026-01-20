package com.boi.repository;

import com.boi.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * team: team-1
 */
public class JdbcAccountRepository {

    private static Logger logger = LoggerFactory.getLogger("boi");

    public JdbcAccountRepository(){
        logger.info("JdbcAccountRepository initialized.");
    }

    public Account loadAccount(String accountNumber) {
        logger.info("Loading account for account number: " + accountNumber);
        //..
        return new Account(accountNumber, "A", 1000.0);
    }

    public void updateAccount(Account account) {
        logger.info("Updating account: " + account);
        //..
    }

}
