package com.boi.repository;

public class AccountRepositoryFactory {

    public static AccountRepository getAccountRepository(String type) {
        if (type.equalsIgnoreCase("SQL")) {
            return new SQLAccountRepository(null);
        } else if (type.equalsIgnoreCase("NoSQL")) {
            return new NoSQLAccountRepository();
        } else {
            throw new IllegalArgumentException("Unknown repository type: " + type);
        }
    }

}
