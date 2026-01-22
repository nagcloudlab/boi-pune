package com.boi.analyticalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class AnalyticalServiceApplication {


    @KafkaListener(
        topics = "fund-transfer-events",
        groupId = "analytical-service-group"
    )
    public void handleTransferEvent(String event) {
        // Logic to process the transfer event and perform analytics
        System.out.println("Processing transfer event: " + event);
        // delay
        try {
            Thread.sleep(10); // Simulate processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Completed processing transfer event: " + event);
    }

    public static void main(String[] args) {
        SpringApplication.run(AnalyticalServiceApplication.class, args);
    }

}
