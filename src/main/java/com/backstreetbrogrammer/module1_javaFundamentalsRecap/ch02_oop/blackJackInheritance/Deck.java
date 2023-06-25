package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch02_oop.blackJackInheritance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        final String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (final String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                int value = i + 1;

                if (ranks[i].equals("Ace")) {
                    value = 11;
                } else if (i >= 9) {
                    value = 10;
                }

                final Card card = new Card(suit, ranks[i], value);
                cards.add(card);
            }
        }

        Collections.shuffle(cards);
    }

    public Card dealCard() {
        return cards.remove(0);
    }

}
