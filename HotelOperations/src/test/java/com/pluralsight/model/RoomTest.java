package com.pluralsight.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoomTest {
    private Room room100;
    private Room room101;
    private Room room102;
    private Room room103;

    @BeforeEach
    public void setUp() {
        room100 = new Room(2, 200.00f, false, false);
        room101 = new Room(2, 200.00f, true, true);
        room102 = new Room(2, 200.00f, false, true);
        room103 = new Room(2, 200.00f, true, false);
    }

    @Test
    public void should_check_in() {
        assertTrue(room100.isAvailable());
        room100.checkIn();
        assertFalse(room100.isAvailable());
        assertFalse(room100.checkIn());
    }

    @Test
    public void should_not_check_in() {
        assertFalse(room101.isAvailable());
        assertFalse(room101.checkIn());
        assertFalse(room102.isAvailable());
        assertFalse(room102.checkIn());
    }

    @Test
    public void should_check_out() {
        assertFalse(room101.isAvailable());
        room101.checkOut();
        assertTrue(room101.isAvailable());
    }

    @Test
    public void should_clean_room() {
        assertFalse(room102.isAvailable());
        assertTrue(room102.cleanroom());
        assertTrue(room102.isAvailable());
        assertFalse(room102.cleanroom());
    }

}