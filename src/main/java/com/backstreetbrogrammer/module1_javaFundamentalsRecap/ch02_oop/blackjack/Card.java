package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch02_oop.blackjack;

public class Card {
    Rank rank;
    Suit suit;

    public Card(final String rank, final String suit) {
        this.rank = Rank.get(rank);
        this.suit = Suit.get(suit);
    }

    @Override
    public String toString() {
        return String.format("%s of %s", rank.rank(), suit.suit());
    }
}
