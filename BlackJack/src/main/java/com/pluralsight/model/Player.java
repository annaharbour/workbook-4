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

    public Hand getHand() {
        return this.hand;
    }

    public int getHandValue() {
        return hand.getValue();
    }

    public void hit(Deck deck) {
        Card card = deck.deal();
        hand.deal(card);

    }

    public void stay() {
        System.out.println(this.name + " stays.");

    }
}
