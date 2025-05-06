package com.pluralsight.model;

import java.time.LocalDateTime;

public class Employee {
    private final String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double regularHours;

    public Employee(String employeeId, String name, String department, float payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.regularHours = 40;
    }

    public double getTotalPay() {
        return (this.payRate * this.regularHours) + (this.payRate * 1.5 * this.getOverTimeHours());
    }

    public void setRegularHours(double regularHours) {
        this.regularHours = regularHours;
    }

    public double getRegularHours() {
        return Math.min(this.hoursWorked, this.regularHours);
    }

    public double getOverTimeHours() {
        return this.hoursWorked > regularHours ? this.hoursWorked - regularHours : 0;
    }

    public void punchTimeCard(LocalDateTime clockIn, LocalDateTime clockOut) {
        if(clockIn.isAfter(clockOut)) {
            System.out.println("Clock in must precede clock out");
            return;
        }
        double hours = java.time.Duration.between(clockIn, clockOut).toMinutes() / 60.0;
        this.hoursWorked += hours;
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
