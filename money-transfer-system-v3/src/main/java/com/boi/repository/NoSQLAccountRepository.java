package com.boi.repository;

import com.boi.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * team: team-1
 */
@Component("noSQLAccountRepository")
public class NoSQLAccountRepository implements AccountRepository{

    private static Logger logger = LoggerFactory.getLogger("boi");

    public NoSQLAccountRepository(){
        logger.info("NoSQLAccountRepository initialized.");
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
