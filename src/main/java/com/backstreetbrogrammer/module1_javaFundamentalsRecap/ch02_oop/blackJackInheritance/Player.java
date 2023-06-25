package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch02_oop.blackJackInheritance;

public class Player extends Participant {
    private int chips;

    public Player(final int chips) {
        super();
        this.chips = chips;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(final int chips) {
        this.chips = chips;
    }
}
