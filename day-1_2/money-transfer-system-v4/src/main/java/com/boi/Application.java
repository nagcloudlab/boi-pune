package com.boi;

import com.boi.service.TransferService;
import com.boi.service.UPITransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.boi")
@EnableTransactionManagement
public class Application {

    private static Logger logger = LoggerFactory.getLogger("boi");

    public static void main(String[] args) {


        //---------------------------------------
        // Init / boot phase
        //---------------------------------------
        System.out.println("-".repeat(50));
        // based on configuration, initialize components

        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Application.class, args);

        logger.info("Money Transfer System Initialized.");
        logger.info("-".repeat(50));
        //---------------------------------------
        // Run/ Use  phase
        //---------------------------------------
        //
        // Simulate a money transfer
        String fromAccount = "1";
        String toAccount = "2";
        double amount = 100.00;

        TransferService upiTransferService =
                (UPITransferService) applicationContext.getBean("upiTransferService");

        upiTransferService.transfer(amount, fromAccount, toAccount);

        logger.info("-".repeat(50));
        //---------------------------------------
        // Shutdown phase
        //---------------------------------------
        // cleanup resources if any
        logger.info("-".repeat(50));

    }
}
