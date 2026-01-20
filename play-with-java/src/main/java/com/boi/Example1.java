package com.boi;

import java.time.LocalDateTime;
import java.util.List;

import com.boi.model.Transaction;
import com.boi.model.TransactionType;

public class Example1 {

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction(1, 100.00, TransactionType.DEPOSIT, 123, LocalDateTime.of(2024, 6, 1, 0, 0),
                        "Initial deposit"),
                new Transaction(2, 50.00, TransactionType.WITHDRAWAL, 456, LocalDateTime.of(2024, 6, 2, 0, 0),
                        "ATM withdrawal"),
                new Transaction(3, 200.00, TransactionType.DEPOSIT, 789, LocalDateTime.of(2024, 6, 3, 0, 0),
                        "Paycheck deposit"),
                new Transaction(4, 30.00, TransactionType.WITHDRAWAL, 123, LocalDateTime.of(2024, 6, 4, 0, 0),
                        "Grocery shopping"),
                new Transaction(5, 20.00, TransactionType.WITHDRAWAL, 456, LocalDateTime.of(2024, 6, 5, 0, 0),
                        "Gas station"));

        // filter withdrawals transactions into new list

    }

}
