package com.pluralsight;

import com.pluralsight.model.Deck;
import com.pluralsight.model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//      initialize a new deck and shuffle it
        Deck deck = new Deck();
        deck.shuffle();
//      get number of players and player names
        ArrayList<Player> players = getPlayers(scanner);
        for (Player player : players) {
            System.out.println(player.getName() + "'s turn:");
            for (int i = 0; i < 2; i++) {
                player.hit(deck);
            }
            int handValue = player.getHandValue();
            System.out.println(player.getName() + "'s initial hand is worth " + handValue);
        }
        //      play game
        playGame(players, deck, scanner);
    }

    private static void playGame(ArrayList<Player> players, Deck deck, Scanner scanner) {
        Player closestPlayer = null;
        int closestTo21 = 0;

        while (deck.getSize() > 0 && players.size() > 1) {
            for (Player player : players) {
                System.out.println(player.getName() + ": hit or stay?");
                String choice = scanner.nextLine().toLowerCase();
                if (choice.equals("hit")) {
                    player.hit(deck);
                    int handValue = player.getHandValue();
                    System.out.println(player.getName() + "'s hand is now worth " + handValue);
                    if (handValue > 21) {
                        System.out.println(player.getName() + " has busted!");
                        players.remove(player);
                        break;
                    } else {
                        if (handValue > closestTo21) {
                            closestTo21 = handValue;
                            closestPlayer = player;
                        }
                    }
                } else if (choice.equals("stay")) {
                    player.stay();
                } else {
                    System.out.println("Please enter 'hit' or 'stay'.");
                }
                int handValue = player.getHandValue();
                System.out.println(player.getName() + "'s hand is worth " + handValue);
            }
        }

        System.out.println(closestPlayer.getName() + " is the winner with: " + closestTo21 + " points");
    }

    private static ArrayList getPlayers(Scanner scanner) {
        ArrayList<Player> players = new ArrayList<>();
        System.out.println("How many users are playing?");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();
        if (numberOfPlayers <= 0) {
            System.out.println("Must enter a valid number of players");
            return getPlayers(scanner);
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter name for Player #" + (i + 1) + ":");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName));
        }
        return players;
    }
}