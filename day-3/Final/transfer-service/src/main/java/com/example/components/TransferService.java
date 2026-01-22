package com.example.components;

import org.springframework.beans.factory.annotation.Autowired;

/*
// dev-1
*/

@org.springframework.stereotype.Service
public class TransferService implements Service {

    Repo accRepo;

    @Autowired
    public TransferService(Repo accRepo) {
        this.accRepo = accRepo;
    }

    public boolean transfer(String id) {
        String account = accRepo.getAccount(id);
        if (account != null) {
            return true;
        }
        return false;
    }

}
