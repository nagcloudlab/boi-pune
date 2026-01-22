package com.boi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class NotificationServiceApplication {

    @KafkaListener(
        topics = "fund-transfer-events",
        groupId = "notification-service-group"
    )
    public void handleTransferEvent(String event) {
        // Logic to handle transfer event and send notification
        System.out.println("Handling transfer event: " + event);
    }


    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

}
