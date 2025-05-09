package com.pluralsight.model;

import java.util.Scanner;

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
        if (isFaceUp()) {
            // this is the string value of the card
            // i.e. A, K, Q, J, 10, 9 ...
            return value;
        } else {
            return "#";
        }
    }

    public String getSuit() {
        if (isFaceUp()) {
            return suit;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
        int pointValue = 0;
        switch (this.getValue()) {
            case "A":
                break;
            case "K", "Q", "J":
                pointValue = 10;
                break;
            default:
                pointValue = Integer.parseInt(this.value);
                break;
        };

        return pointValue;
    }

    public boolean flip() {
        isFaceUp = !isFaceUp;
        return isFaceUp;
    }
}
