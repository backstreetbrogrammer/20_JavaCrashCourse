package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch01_javaFundamentals;

import org.junit.jupiter.api.Test;

public class IsPalindromeNumberTest {

    @Test
    void testPalindromeNumber() {
        final var nums = new int[]{1, 6, 11, 121, 333, 2147412, -1, 12, 100, 2147483647};
        for (final var num : nums) {
            System.out.printf("Num=[%d], isPalindrome=[%b]%n", num, IsPalindromeNumber.isPalindromeNumber(num));
        }
    }

}
