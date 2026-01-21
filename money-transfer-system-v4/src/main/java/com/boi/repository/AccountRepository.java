package com.boi.repository;

import com.boi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component("sqlAccountRepository")
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
