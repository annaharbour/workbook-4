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

    public void checkIn() {
        if(!isAvailable()){
            System.out.println("Cannot check in, room occupied");
            return;
        }
        this.isOccupied = true;
        this.isDirty = true;
    }

    public void checkOut() {
        this.isOccupied = false;
        cleanroom();
    }

    public void cleanroom(){
        this.isDirty = false;
    }
}
