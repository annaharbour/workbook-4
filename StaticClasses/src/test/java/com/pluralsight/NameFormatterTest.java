package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    @org.junit.jupiter.api.Test
    void shouldFormatFullName() {
        assertEquals("Johnson, Dr. Mel B, Phd", NameFormatter.format("Dr. Mel B Johnson, Phd"));
        assertEquals("Johnson, Mel B, PhD", NameFormatter.format("Mel B Johnson, PhD"));

    }

    @org.junit.jupiter.api.Test
    void shouldFormatFirstLast() {
        assertEquals("Johnson, Mel", NameFormatter.format("Mel Johnson"));

    }

    @org.junit.jupiter.api.Test
    void shouldFormatNamePieces() {
        assertEquals("Johnson, Dr Mel B, Phd", NameFormatter.format("Dr", "Mel", "B", "Johnson", "Phd"));

    }
}