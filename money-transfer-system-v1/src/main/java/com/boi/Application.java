package com.boi;

import com.boi.service.UPITransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static Logger logger = LoggerFactory.getLogger("boi");

    public static void main(String[] args) {

        //---------------------------------------
        // Init / boot phase
        //---------------------------------------
        System.out.println("-".repeat(50));
        // based on configuration, initialize components
        UPITransferService transferService = new UPITransferService();

        logger.info("Money Transfer System Initialized.");
        logger.info("-".repeat(50));
        //---------------------------------------
        // Run/ Use  phase
        //---------------------------------------
        //
        // Simulate a money transfer
        String fromAccount = "user1@bank";
        String toAccount = "user2@bank";
        double amount = 1000.00;

        transferService.transfer(amount, fromAccount, toAccount);

        logger.info("-".repeat(50));
        //---------------------------------------
        // Shutdown phase
        //---------------------------------------
        // cleanup resources if any
        logger.info("-".repeat(50));

    }
}
