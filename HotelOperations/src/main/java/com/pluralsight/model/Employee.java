package com.pluralsight.model;

import java.time.LocalDateTime;

public class Employee {
    private final String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double regularHours = 40;
    private LocalDateTime punchIn;

    public Employee(String employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
    }

    public double getTotalPay() {
        return (this.payRate * this.getRegularHours()) + (this.payRate * 1.5 * this.getOverTimeHours());
    }

    public double getRegularHours() {
        return Math.min(this.hoursWorked, this.regularHours);
    }

    public double getOverTimeHours() {
        return this.hoursWorked > regularHours ? this.hoursWorked - regularHours : 0;
    }

    public void punchIn() {
        this.punchIn = LocalDateTime.now();
    }

    public double punchOut() {
        if (punchIn == null) {
            throw new IllegalStateException("Must punch in before punching out");
        }
        return this.punchTimeCard(punchIn, LocalDateTime.now());
    }

    public double punchTimeCard(LocalDateTime clockIn, LocalDateTime clockOut) {
        if (clockIn.isAfter(clockOut)) {
            throw new IllegalArgumentException("Clock in must precede clock out");
        }
        double hours = java.time.Duration.between(clockIn, clockOut).toMinutes() / 60.0;
        this.hoursWorked += hours;
        return hours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", payRate=" + payRate +
                ", hoursWorked=" + hoursWorked +
                ", regularHours=" + regularHours +
                '}';
    }
}
