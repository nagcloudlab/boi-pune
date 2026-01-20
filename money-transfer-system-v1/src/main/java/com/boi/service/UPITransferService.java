package com.boi.service;

import com.boi.model.Account;
import com.boi.repository.JdbcAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UPITransferService {

    private static Logger logger = LoggerFactory.getLogger("boi");

    public UPITransferService(){
        logger.info("UPITransferService initialized.");
    }

    public void transfer(double amount, String fromUPI, String toUPI) {
        logger.info("Initiating transfer of amount: " + amount + " from " + fromUPI + " to " + toUPI);

        JdbcAccountRepository accountRepository = new JdbcAccountRepository();
        Account fromAccount = accountRepository.loadAccount(fromUPI);
        Account toAccount = accountRepository.loadAccount(toUPI);

        fromAccount.debit(amount);
        toAccount.credit(amount);

        accountRepository.updateAccount(fromAccount);
        accountRepository.updateAccount(toAccount);

        logger.info("Transfer completed successfully.");

    }

}
