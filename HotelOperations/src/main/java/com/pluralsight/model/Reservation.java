package com.pluralsight.model;

public class Reservation {
    private enum RoomType {KING, DOUBLE};
    private RoomType roomType;
    private int numberOfNights = 0;
    private boolean isWeekend = false;

    public Reservation(RoomType roomType, int numberOfNights, float price, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return this.roomType != null ? this.roomType.name() : null;
    }

    public void setRoomType(String roomType) {
        this.roomType = RoomType.valueOf(roomType.toUpperCase());
    }


    public float getPrice() {
        float price = 0.00f;
        if (this.roomType == RoomType.KING) {
            price += 139.00f;
        } else {
            price += 124.00f;
        }
        price *= this.isWeekend ? 1.1f : 1f;
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public float getReservationTotal() {
        return this.getPrice() * this.numberOfNights;
    }
}
