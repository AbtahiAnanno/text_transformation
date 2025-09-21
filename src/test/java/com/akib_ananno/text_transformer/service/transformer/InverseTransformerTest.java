package com.akib_ananno.text_transformer.service.transformer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InverseTransformerTest {

    // Instantiate the class we want to test
    private final InverseTransformer transformer = new InverseTransformer();

    @Test
    @DisplayName("Should correctly reverse a mixed-case string")
    void shouldReverseMixedCaseString() {
        // Arrange
        String inputText = "MirEk";
        String expectedText = "KerIm";

        // Act
        String actualText = transformer.transform(inputText);

        // Assert
        assertEquals(expectedText, actualText);
    }

    @Test
    @DisplayName("Should return an empty string for an empty input")
    void shouldHandleEmptyString() {
        assertEquals("", transformer.transform(""));
    }

    @Test
    @DisplayName("Should return null for a null input")
    void shouldHandleNullInput() {
        assertNull(transformer.transform(null));
    }

    @Test
    @DisplayName("Should handle a single lowercase character")
    void shouldHandleSingleLowerCaseChar() {
        assertEquals("a", transformer.transform("a"));
    }

    @Test
    @DisplayName("Should handle a single uppercase character")
    void shouldHandleSingleUpperCaseChar() {
        assertEquals("A", transformer.transform("A"));
    }

    @Test
    @DisplayName("Should correctly reverse a string with numbers and symbols")
    void shouldHandleNumbersAndSymbols() {
        String inputText = "TeSt123&";
        String expectedText = "&321tSeT";
        assertEquals(expectedText, transformer.transform(inputText));
    }

    @Test
    @DisplayName("Should correctly reverse a string with all caps")
    void shouldHandleAllCaps() {
        String inputText = "HELLO";
        String expectedText = "OLLEH";
        assertEquals(expectedText, transformer.transform(inputText));
    }

    @Test
    @DisplayName("Should handle a mixed-case palindrome")
    void shouldHandlePalindrome() {
        // A palindrome should remain the same after this transformation
        String inputText = "RaCecAr";
        String expectedText = "RaCecAr";
        assertEquals(expectedText, transformer.transform(inputText));
    }
}