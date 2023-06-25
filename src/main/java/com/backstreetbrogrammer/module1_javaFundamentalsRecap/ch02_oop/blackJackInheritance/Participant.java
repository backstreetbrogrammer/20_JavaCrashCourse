package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch02_oop.blackJackInheritance;

public abstract class Participant {
    private final Hand hand;

    public Participant() {
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void addCardToHand(final Card card) {
        hand.addCard(card);
    }

    public int getHandValue() {
        return hand.getValue();
    }
}
