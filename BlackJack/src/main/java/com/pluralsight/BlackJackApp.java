package com.pluralsight;

import com.pluralsight.model.Deck;
import com.pluralsight.model.Game;
import com.pluralsight.model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = getPlayers(scanner);
        Deck deck = new Deck();
        deck.shuffle();
        Game game = new Game(players, deck);
        game.startGame();

        while (game.getActivePlayers().size() > 1 && deck.getSize() > 0) {
            for (Player player : game.getActivePlayers()) {
                System.out.println(player.getName() + ": Hit or Stay?");
                String choice = scanner.nextLine().toLowerCase();
                game.playRound(player, choice);

                if (player.isBusted()) {
                    System.out.println(player.getName() + " has busted!");
                    if(game.getActivePlayers().size() == 1){
                        break;
                    }
                }
            }
        }
        game.declareWinner();
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