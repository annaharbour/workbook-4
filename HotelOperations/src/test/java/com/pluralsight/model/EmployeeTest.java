package com.pluralsight.model;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {
    private Employee employee;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        employee = new Employee("007", "James Bond", "MI6", 1000.00f);
    }

    @org.junit.jupiter.api.Test
    public void should_get_total_Pay() {
        employee.punchTimeCard(LocalDateTime.now(), LocalDateTime.now().plusHours(168));
        assertEquals(232000, employee.getTotalPay());
    }

    @org.junit.jupiter.api.Test
    void should_get_overtime_hours() {
        employee.punchTimeCard(LocalDateTime.now(), LocalDateTime.now().plusHours(168));
        assertEquals(128, employee.getOverTimeHours());
    }

    @org.junit.jupiter.api.Test
    void should_punch_time_card() {
        try {
            assertThrows(IllegalArgumentException.class, () -> employee.punchTimeCard(LocalDateTime.now().plusDays(1),
                    LocalDateTime.now()));
        } catch (IllegalArgumentException e){
            System.out.println("Exception expected and ignored: " + e.getMessage());
        }
        employee.punchTimeCard(LocalDateTime.now(), LocalDateTime.now().plusDays(1));
    }

}