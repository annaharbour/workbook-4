package com.pluralsight.model;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private float payRate;
    private double hoursWorked;
    private double regularHours;

    public Employee(String employeeId, String name, String department, float payRate, double hoursWorked,
                    double regularHours) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.regularHours = regularHours;
    }

    public float getTotalPay() {
        return this.payRate * (float) this.hoursWorked;
    }

    public double setRegularHours(double regularHours) {
        return this.regularHours = regularHours;
    }

    public double getRegularHours() {
        return this.hoursWorked < regularHours ? this.hoursWorked : regularHours;
    }

    public double getOverTimeHours() {
        return this.hoursWorked > regularHours ? this.hoursWorked - regularHours : 0;
    }
}
