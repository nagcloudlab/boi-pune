package com.example.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransferServiceIntegrationTest {

    @Autowired
    private Service transferService;

    @org.junit.jupiter.api.Test
    public void testTransferService() {
        boolean b = transferService.transfer("123");
        assertTrue(b);
    }

}
