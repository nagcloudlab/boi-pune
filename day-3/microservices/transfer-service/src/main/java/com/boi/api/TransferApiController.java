package com.boi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfer")
public class TransferApiController {

    @PostMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    public TransferResponse transferFunds(@RequestBody TransferRequest request) {
        // Implement the logic to process the fund transfer here
        // For now, we will return a dummy response
        TransferResponse response = new TransferResponse();
        response.setStatus("SUCCESS");
        response.setTransactionId("TX123456789");
        return response;
    }

}
