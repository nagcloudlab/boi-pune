package com.boi.model;

import java.time.LocalDateTime;

public class Transaction {

    private long id;
    private double amount;
    private TransactionType type;
    private long accountId;
    private LocalDateTime date;
    private String description;

    public Transaction(long id, double amount, TransactionType type, long accountId, LocalDateTime date,
            String description) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.accountId = accountId;
        this.date = date;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public long getAccountId() {
        return accountId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    // Additional methods like toString(), equals(), and hashCode() can be added as
    // needed

    // toString() method for better readability
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", type=" + type +
                ", accountId=" + accountId +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }

}
