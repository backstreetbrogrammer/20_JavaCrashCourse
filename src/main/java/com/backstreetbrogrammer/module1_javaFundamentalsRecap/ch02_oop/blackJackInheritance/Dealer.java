package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch02_oop.blackJackInheritance;

public class Dealer extends Participant {
    public Dealer() {
        super();
    }

    public Card getUpCard() {
        return getHand().getCards().get(1);
    }
}
