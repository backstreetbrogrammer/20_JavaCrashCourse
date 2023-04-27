package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch02_oop.blackjack;

import java.util.Arrays;

public enum Rank {
    ACE("Ace"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    UNKNOWN("Unknown Rank");

    private final String rank;

    Rank(final String rank) {
        this.rank = rank;
    }

    public String rank() {
        return rank;
    }

    public static Rank get(final String s) {
        return Arrays.stream(Rank.values())
                     .filter(r -> r.rank.equals(s))
                     .findFirst()
                     .orElse(UNKNOWN);
    }
}
