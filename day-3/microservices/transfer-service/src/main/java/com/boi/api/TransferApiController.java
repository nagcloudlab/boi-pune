package com.boi.api;

import com.boi.dto.TransferRequest;
import com.boi.dto.TransferResponse;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfer")
public class TransferApiController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    public TransferResponse transferFunds(@RequestBody TransferRequest request) {
        //...

        // New Transfer Event
        // publish to message to kafka topic

        String jsonMessage = "{ \"fromAccount\": \"" + request.getFromAccount() + "\", " +
                "\"toAccount\": \"" + request.getToAccount() + "\", " +
                "\"amount\": " + request.getAmount() + " }";

        ProducerRecord<String, String> record = new ProducerRecord<>("fund-transfer-events", jsonMessage);
        kafkaTemplate.send(record);

        TransferResponse response = new TransferResponse();
        response.setStatus("SUCCESS");
        response.setTransactionId("TX123456789");
        return response;
    }


}
