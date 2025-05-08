package com.pluralsight.model;

public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public boolean isFaceUp() {
        return this.isFaceUp;
    }

    public String getValue() {
        if (this.isFaceUp) {
            // this is the string value of the card
            // i.e. A, K, Q, J, 10, 9 ...
            return value;
        } else {
            return "#";
        }
    }

    public String getSuit() {
        if (this.isFaceUp) {
            return suit;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
        int pointValue = 0;
        if (this.isFaceUp) {
            pointValue = switch (this.value) {
                case "A" -> 11;
                case "K", "Q", "J" -> 10;
                default -> Integer.parseInt(this.value);
            };
        }
        return pointValue;
    }

    public boolean flip() {
        isFaceUp = !isFaceUp;
        return isFaceUp;
    }
}
