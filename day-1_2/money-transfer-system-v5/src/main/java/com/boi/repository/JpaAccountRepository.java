package com.boi.repository;

import com.boi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRepository extends JpaRepository<Account, String> {
}
