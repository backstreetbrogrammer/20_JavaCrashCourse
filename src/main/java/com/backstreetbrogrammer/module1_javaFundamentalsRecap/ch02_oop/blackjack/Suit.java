package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch02_oop.blackjack;

import java.util.Arrays;

public enum Suit {
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades"),
    UNKNOWN("Unknown Suit");

    private final String suit;

    Suit(final String suit) {
        this.suit = suit;
    }

    public String suit() {
        return suit;
    }

    public static Suit get(final String s) {
        return Arrays.stream(Suit.values())
                     .filter(r -> r.suit.equals(s))
                     .findFirst()
                     .orElse(UNKNOWN);
    }
}
