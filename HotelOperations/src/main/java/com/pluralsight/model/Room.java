package com.pluralsight.model;

public class Room {
    private int numberOfBeds;
    private float price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds, float price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public boolean isAvailable() {
        return !this.isDirty && !this.isOccupied;
    }

    public boolean checkIn() {
        if (!this.isAvailable()) {
            System.out.println("Cannot check in, room occupied");
            return false;
        }
        this.isOccupied = true;
        this.isDirty = true;
        return true;
    }

    public boolean checkOut() {
        if (!this.isOccupied) {
            return false;
        }
        this.isOccupied = false;
        cleanroom();
        return true;
    }

    public boolean cleanroom() {
        if (!this.isDirty) {
            return false;
        }
        this.isDirty = false;
        return true;

    }
}
