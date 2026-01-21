package com.boi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "account_id", nullable = false, unique = true)
    private String accountId;
    @Column(name = "account_holder_name", nullable = false, unique = true)
    private String accountHolderName;
    @Column(name = "balance", nullable = false)
    private double balance;
}
