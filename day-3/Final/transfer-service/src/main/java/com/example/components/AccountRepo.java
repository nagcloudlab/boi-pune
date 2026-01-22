package com.example.components;

import org.springframework.stereotype.Repository;

/*
// dev-2
 */

@Repository
public class AccountRepo implements Repo {

    public String getAccount(String id) {
        return "Account-" + id;
    }

}
