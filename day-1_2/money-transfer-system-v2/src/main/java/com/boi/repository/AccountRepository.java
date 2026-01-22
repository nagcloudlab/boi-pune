package com.boi.repository;

import com.boi.model.Account;

public interface AccountRepository {
    Account loadAccount(String accountNumber);
    void updateAccount(Account account);
}
