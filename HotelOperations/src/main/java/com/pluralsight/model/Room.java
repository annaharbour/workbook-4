package com.pluralsight.model;

public class Room {
    private int numberOfBeds;
    private float price;
    private boolean isOccupied;
    private boolean isDirty;
    private boolean isAvailable;

    public Room(int numberOfBeds, float price, boolean isOccupied, boolean isDirty, boolean isAvailable) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
        this.isAvailable = isAvailable;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }


    public float getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public void setIsOccupied(boolean isOccupied){
        this.isOccupied = isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setIsDirty(boolean isDirty) {
        this.isDirty = isDirty;
    }

    public boolean isAvailable() {
        return !this.isDirty && !this.isOccupied;
    }
}
