package com.pluralsight.model;

import java.util.List;

public class Game {
    private Deck deck;
    private List<Player> players;
    private Player winner;

    public Game(List<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    public List<Player> getActivePlayers() {
        return players.stream().filter(player -> !player.isBusted()).toList();
    }

    public void startGame() {
        for (Player player : players) {
            System.out.println(player.getName() + "'s initial hand:");
            for (int i = 0; i < 2; i++) {
                player.hit(this.deck);
            }
            int handValue = player.getHandValue();
            System.out.println(player.getName() + "'s initial hand is worth " + handValue);
        }
    }

    public void playRound(Player player, String choice) {
        if (choice.equals("hit")) {
            player.hit(deck);
            System.out.println(player.getName() + "'s hand is now worth " + player.getHandValue());
            player.printHand();
        } else if (choice.equals("stay")) {
            player.stay();
        }
    }

    public void declareWinner() {
        int winningHandValue = 0;
        Player winner = null;
        for (Player player : getActivePlayers()) {
            if (player.getHandValue() > winningHandValue) {
                winningHandValue = player.getHandValue();
                winner = player;
            }
        }
        if (winner != null) {
            System.out.println("The winner is... " + winner.getName());
        }
        this.winner = winner;
    }
}

