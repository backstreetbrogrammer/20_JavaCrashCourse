package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch01_javaFundamentals;

import org.junit.jupiter.api.Test;

public class ReverseDigitsTest {

    @Test
    void testReverse() {
        final int[] nums = new int[]{1234, -975, 5436, 87580, -1};
        for (final int num : nums) {
            System.out.printf("Reverse of %d is %d%n", num, ReverseDigits.reverse(num));
        }
    }
}
