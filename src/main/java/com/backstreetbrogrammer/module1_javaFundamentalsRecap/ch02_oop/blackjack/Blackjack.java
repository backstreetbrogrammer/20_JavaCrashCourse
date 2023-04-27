package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch02_oop.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Blackjack {

    private final List<Card> deck;

    public Blackjack() {
        this.deck = newDeck();
        Collections.shuffle(deck);
    }

    public List<Card> getDeck() {
        return deck;
    }

    // Creates a new deck of 52 cards
    private List<Card> newDeck() {
        final String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        final List<Card> deck = new ArrayList<>();
        for (final String rank : ranks) {
            for (final String suit : suits) {
                deck.add(new Card(rank, suit));
            }
        }
        return deck;
    }

    // Calculates the value of a hand of cards
    private int getHandValue(final List<Card> hand) {
        int value = 0;
        boolean hasAce = false;
        for (final Card card : hand) {
            final Rank rank = card.rank;
            if (rank == Rank.ACE) {
                hasAce = true;
                value += 11;
            } else if (rank == Rank.KING || rank == Rank.QUEEN || rank == Rank.JACK) {
                value += 10;
            } else {
                value += Integer.parseInt(rank.rank());
            }
        }
        if (hasAce && value > 21) {
            value -= 10;
        }
        return value;
    }

    private boolean isBusted(final List<Card> hand) {
        return getHandValue(hand) > 21;
    }

    private boolean isBlackJack(final List<Card> hand) {
        return getHandValue(hand) == 21;
    }

    public static void main(final String[] args) {
        try (final Scanner input = new Scanner(System.in)) {
            final Blackjack blackjack = new Blackjack();
            final List<Card> deck = blackjack.getDeck();

            // Initialize player's and dealer's hands
            final List<Card> playerHand = new ArrayList<>();
            final List<Card> dealerHand = new ArrayList<>();

            // Deal initial cards
            Collections.shuffle(deck);

            playerHand.add(deck.remove(0));
            dealerHand.add(deck.remove(0));
            playerHand.add(deck.remove(0));
            dealerHand.add(deck.remove(0));

            // Show initial hands
            System.out.println("Your hand: " + playerHand);
            System.out.println("Dealer's hand: " + dealerHand.get(0) + ", [hidden]");

            // Player's turn
            while (true) {
                System.out.print("Do you want to 'hit' or 'stand'? ");
                final String choice = input.nextLine();
                if (choice.equalsIgnoreCase("hit")) {
                    playerHand.add(deck.remove(0));
                    System.out.println("Your hand: " + playerHand);
                    if (blackjack.isBusted(playerHand)) {
                        System.out.println("Bust! You lose.");
                        return;
                    } else if (blackjack.isBlackJack(playerHand)) {
                        System.out.println("BlackJack!! You win.");
                        return;
                    }
                } else if (choice.equalsIgnoreCase("stand")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'hit' or 'stand'.");
                }
            }

            // Dealer's turn
            while (blackjack.getHandValue(dealerHand) < 17) {
                dealerHand.add(deck.remove(0));
                System.out.println("Dealer's hand: " + dealerHand);
                if (blackjack.isBusted(dealerHand)) {
                    System.out.println("Dealer busts! You win.");
                    return;
                } else if (blackjack.isBlackJack(dealerHand)) {
                    System.out.println("Dealers BlackJack!! You lose.");
                    return;
                }
            }

            // Compare hands
            final int playerValue = blackjack.getHandValue(playerHand);
            final int dealerValue = blackjack.getHandValue(dealerHand);
            System.out.printf("Your points=[%d], Dealers points=[%d]%n", playerValue, dealerValue);
            if (playerValue > dealerValue) {
                System.out.println("You win!");
            } else if (dealerValue > playerValue) {
                System.out.println("Dealer wins.");
            } else {
                System.out.println("It's a tie.");
            }
        }
    }

}
