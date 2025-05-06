package com.pluralsight.model;

public class Hotel {
    private final String name;
    private final int numberOfSuites;
    private final int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(int numberOfRooms, int numberOfSuites, String name) {
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
        this.bookedBasicRooms = 0;
        this.bookedSuites = 0;
        this.name = name;
    }

    public Hotel(int numberOfRooms, int numberOfSuites, int bookedBasicRooms, int bookedSuites, String name) {
        this.bookedBasicRooms = bookedBasicRooms;
        this.bookedSuites = bookedSuites;
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    public int getAvailableRooms() {
        return this.numberOfRooms - this.bookedBasicRooms;
    }

    public int getAvailableSuites() {
        return this.numberOfSuites - this.bookedSuites;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        System.out.printf("\nAttempting to book %d %s\n", numberOfRooms, isSuite ? "suites" : "basic rooms");
        if (isSuite) {
            if (numberOfRooms <= this.getAvailableSuites()) {
                this.bookedSuites += numberOfRooms;
                System.out.println("Booking complete");
                return true;
            }
            System.out.println("Not enough suites remaining");
        } else {
            int availableBasicRooms = this.numberOfRooms - this.bookedBasicRooms;
            if (numberOfRooms <= availableBasicRooms) {
                this.bookedBasicRooms += numberOfRooms;
                System.out.println("Booking complete");
                return true;
            }
            System.out.println("Transaction failure: not enough basic rooms remaining");
        }
        return false;
    }

    @Override
    public String toString() {
        return "\n" + name +
                "\nTotal Suites: " + numberOfSuites +
                ", Total Rooms: " + numberOfRooms +
                ", Booked Suites: " + bookedSuites +
                ", Booked Basic Rooms: " + bookedBasicRooms +
                ", Available Suites: " + this.getAvailableSuites() +
                ", Available Rooms: " + this.getAvailableRooms();
    }


}
