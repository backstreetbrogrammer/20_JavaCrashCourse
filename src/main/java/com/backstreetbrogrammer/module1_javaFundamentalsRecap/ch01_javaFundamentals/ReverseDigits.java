package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch01_javaFundamentals;

public class ReverseDigits {

    public static long reverse(final int num) {
        final boolean isNegative = num < 0;
        long result = 0L;
        long remaining = Math.abs(num);
        while (remaining != 0) {
            result = (result * 10) + (remaining % 10);
            remaining /= 10;
        }

        return isNegative ? -result : result;
    }

}
