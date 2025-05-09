package com.pluralsight.model;

import java.util.Scanner;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return this.name;
    }

    public boolean isBusted() {
        return this.getHandValue() > 21;
    }

    public int getHandValue() {
        return hand.getValue();
    }

    public void printHand(){
        for (Card card : hand.getCards()) {
            card.flip(); // Ensure the card is face up to access its details
            System.out.println("Card: " + card.getValue() + " of " + card.getSuit() + ", Point Value: " + card.getPointValue());
            card.flip(); // Flip the card back to its original state
        }
    }

    public void hit(Deck deck) {
        Card card = deck.deal();
        card.flip();
        System.out.println(card.getValue() + " of " + card.getSuit());
        card.flip();
        hand.deal(card);
    }

    public void stay() {
        System.out.println(this.name + " stays.");

    }
}
