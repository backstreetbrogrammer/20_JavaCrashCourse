package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch01_javaFundamentals;

public class ComputeParity {

    public static short parityUsingApi(final long word) {
        final var bitCount = Long.bitCount(word);
        return (short) ((bitCount % 2 == 0) ? 0 : 1);
    }

    // Time complexity: O(n) ~ n is 64-bit length, i.e. 64
    public static short parity(long word) {
        short result = 0;
        while (word != 0L) {
            result ^= (word & 1);
            word >>>= 1;
        }
        return result;
    }

    // Time complexity: O(k) ~ k is no of set bits (1) in word
    public static short parityOptimised(long word) {
        short result = 0;
        while (word != 0L) {
            result ^= 1;
            word &= (word - 1); // drops the lowest set bit (1) of word
        }
        return result;
    }

}
