package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch02_oop.blackJackInheritance;

import java.util.Scanner;

public class BlackjackGame {

    private final Deck deck;
    private final Player player;
    private final Dealer dealer;

    public BlackjackGame(final int startingChips) {
        deck = new Deck();
        player = new Player(startingChips);
        dealer = new Dealer();
    }

    public void play() {
        final Scanner scanner = new Scanner(System.in);

        while (player.getChips() > 0) {
            System.out.println("You have " + player.getChips() + " chips.");

            System.out.print("How much would you like to bet? ");
            final int bet = scanner.nextInt();

            if (bet > player.getChips()) {
                System.out.println("You don't have enough chips to make that bet.");
                continue;
            }

            player.setChips(player.getChips() - bet);

            player.getHand().addCard(deck.dealCard());
            dealer.getHand().addCard(deck.dealCard());
            player.getHand().addCard(deck.dealCard());
            dealer.getHand().addCard(deck.dealCard());

            System.out.println("Dealer's up card: " + dealer.getUpCard().getRank() + " of " + dealer.getUpCard().getSuit());
            System.out.println("Your hand: " + player.getHand().getCards().get(0).getRank() + " of " + player.getHand().getCards().get(0).getSuit() + " and " + player.getHand().getCards().get(1).getRank() + " of " + player.getHand().getCards().get(1).getSuit());
            System.out.println("Your hand value: " + player.getHandValue());

            boolean playerBust = false;
            boolean dealerBust = false;

            // Player's turn
            while (true) {
                System.out.print("Do you want to hit or stand? ");
                final String choice = scanner.next().toLowerCase();

                if (choice.equals("hit")) {
                    final Card card = deck.dealCard();
                    player.getHand().addCard(card);
                    System.out.println("You drew the " + card.getRank() + " of " + card.getSuit());
                    System.out.println("Your hand value: " + player.getHandValue());

                    if (player.getHandValue() > 21) {
                        System.out.println("You busted!");
                        playerBust = true;
                        break;
                    }
                } else {
                    break;
                }
            }

            // Dealer's turn
            if (!playerBust) {
                System.out.println("Dealer's hand: " + dealer.getHand().getCards().get(0).getRank() + " of " + dealer.getHand().getCards().get(0).getSuit() + " and " + dealer.getHand().getCards().get(1).getRank() + " of " + dealer.getHand().getCards().get(1).getSuit());
                System.out.println("Dealer's hand value: " + dealer.getHandValue());

                while (dealer.getHandValue() < 17) {
                    final Card card = deck.dealCard();
                    dealer.getHand().addCard(card);
                    System.out.println("Dealer drew the " + card.getRank() + " of " + card.getSuit());
                    System.out.println("Dealer's hand value: " + dealer.getHandValue());

                    if (dealer.getHandValue() > 21) {
                        System.out.println("Dealer busted!");
                        dealerBust = true;
                        break;
                    }
                }
            }

            // Determine winner
            if (playerBust) {
                System.out.println("You lose!");
            } else if (dealerBust) {
                System.out.println("You win!");
                player.setChips(player.getChips() + (bet * 2));
            } else if (player.getHandValue() > dealer.getHandValue()) {
                System.out.println("You win!");
                player.setChips(player.getChips() + (bet * 2));
            } else if (player.getHandValue() < dealer.getHandValue()) {
                System.out.println("You lose!");
            } else {
                System.out.println("Push!");
                player.setChips(player.getChips() + bet);
            }

            // Reset hands
            player.getHand().getCards().clear();
            dealer.getHand().getCards().clear();
        }

        System.out.println("You're out of chips. Game over!");
    }

    public static void main(final String[] args) {
        final BlackjackGame game = new BlackjackGame(100);
        game.play();
    }
}
