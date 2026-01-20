package com.boi.model;

public class Account {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // debit & credit methods
    public void debit(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }

    public void credit(double amount) {
        balance += amount;
    }

    // toString method
    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName + ", balance=" + balance + "]";
    }

}
