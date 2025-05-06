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

    public int getAvailableSuites(){
        return this.numberOfSuites - this.bookedSuites;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            if (numberOfRooms <= this.getAvailableSuites()) {
                this.bookedSuites += numberOfRooms;
                return true;
            }
        } else {
            int availableBasicRooms = this.numberOfRooms - this.bookedBasicRooms;
            if (numberOfRooms <= availableBasicRooms) {
                this.bookedBasicRooms += numberOfRooms;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", numberOfSuites=" + numberOfSuites +
                ", numberOfRooms=" + numberOfRooms +
                ", bookedSuites=" + bookedSuites +
                ", bookedBasicRooms=" + bookedBasicRooms +
                '}';
    }



}
