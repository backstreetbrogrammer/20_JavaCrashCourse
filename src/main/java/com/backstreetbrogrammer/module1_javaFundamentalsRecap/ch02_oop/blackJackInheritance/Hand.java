package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch02_oop.blackJackInheritance;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(final Card card) {
        cards.add(card);
    }

    public int getValue() {
        int value = 0;
        int numAces = 0;

        for (final Card card : cards) {
            value += card.getValue();

            if (card.getRank().equals("Ace")) {
                numAces++;
            }
        }

        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        return value;
    }

    public List<Card> getCards() {
        return cards;
    }
}
