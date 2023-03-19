package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch01_javaFundamentals;

import org.junit.jupiter.api.Test;

public class PowerTest {

    @Test
    void testPower() {
        final var nums = new double[]{2D, -3D, 1.1D};
        final var pows = new int[]{-3, 0, 1, 2, 3};
        for (final var x : nums) {
            for (final var y : pows) {
                System.out.printf("x=[%.2f], y=[%d], x.powerUsingApi(y)=[%.2f], x.power(y)=[%.2f]%n",
                                  x, y, Power.powerUsingApi(x, y), Power.power(x, y));
            }
            System.out.println();
        }
    }

}
