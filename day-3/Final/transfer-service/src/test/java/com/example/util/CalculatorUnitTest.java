package com.example.util;

import org.junit.jupiter.api.BeforeEach;

public class CalculatorUnitTest {

    // Arrange
    // Act
    // Assert
    Calculator calculator = null;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @org.junit.jupiter.api.Test
    public void testAdd() {
        // Act
        int result = calculator.add(2, 3);
        // Assert
        org.junit.jupiter.api.Assertions.assertEquals(5, result);
    }

    @org.junit.jupiter.api.Test
    public void testSubtract() {
        // Act
        int result = calculator.subtract(5, 3);
        // Assert
        org.junit.jupiter.api.Assertions.assertEquals(2, result);
    }

    @org.junit.jupiter.api.Test
    public void testMultiply() {
        // Act
        int result = calculator.multiply(4, 3);
        // Assert
        org.junit.jupiter.api.Assertions.assertEquals(12, result);
    }

}
