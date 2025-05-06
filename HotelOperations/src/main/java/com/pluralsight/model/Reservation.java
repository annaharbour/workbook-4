package com.pluralsight.model;

public class Reservation {
    private enum RoomType {KING, DOUBLE};
    private RoomType roomType;
    private int numberOfNights = 0;
    private boolean isWeekend = false;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = RoomType.valueOf(roomType.toUpperCase());
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
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

    public float getReservationTotal() {
        return this.getPrice() * this.numberOfNights;
    }
}
