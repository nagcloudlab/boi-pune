package com.example.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TransferServiceUnitTest {

    // Arrage
    Service service;
    Repo accRepoMock;

    @BeforeEach
    public void setUp() {
        accRepoMock = Mockito.mock(Repo.class);
        service = new TransferService(accRepoMock);
    }

    @Test
    public void testTransfer() {
        // Arrange
        Mockito.when(accRepoMock.getAccount("123")).thenReturn("account-123");
        boolean b = service.transfer("123");
        // Assert
        assertTrue(b);
        // Verify
        Mockito.verify(accRepoMock).getAccount("123");
    }

}
