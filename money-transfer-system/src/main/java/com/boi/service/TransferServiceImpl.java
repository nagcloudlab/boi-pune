package com.boi.service;

import com.boi.entity.Account;
import com.boi.repository.JpaAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransferServiceImpl {
    @Autowired
    private JpaAccountRepository accountRepository;

    @Transactional
    public void transfer(String fromAccountId, String toAccountId, double amount) {
        // step-1: load 'from' account
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("From account not found"));
        // step-2: load 'to' account
        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("To account not found"));
        // check sufficient balance
        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance in from account");
        }
        // step-3: debit 'from' account
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        // step-4: credit 'to' account
        toAccount.setBalance(toAccount.getBalance() + amount);
        // step-5: update 'from' account
        accountRepository.save(fromAccount);
        // step-6: update 'to' account
        accountRepository.save(toAccount);
    }

}
