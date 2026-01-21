package com.boi.api;


import com.boi.dto.TransferRequest;
import com.boi.dto.TransferResponse;
import com.boi.service.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfer")
public class TransferApiController {

    @Autowired
    private TransferServiceImpl transferService;

    /*

        POST /api/transfer
        Description: Initiates a fund transfer between two accounts.
        Accept: application/json
        Request Body:
        {
            "fromAccountId": "string",
            "toAccountId": "string",
            "amount": "number",

         }
        Responses:
        200 OK
        {
            "transactionId": "string",
            "status": "string",
            "timestamp": "string"
        }

     */

    @PostMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    public TransferResponse initiateTransfer(@RequestBody TransferRequest transferRequest) {
        transferService.transfer(
                transferRequest.getFromAccountId(),
                transferRequest.getToAccountId(),
                transferRequest.getAmount()
        );
        TransferResponse response = new TransferResponse();
        response.setTransactionId(12121212);
        response.setStatus("SUCCESS");
        response.setMessage("Transfer completed successfully");
        return response;
    }
}
