package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch01_javaFundamentals;

import org.junit.jupiter.api.Test;

public class ComputeParityTest {

    @Test
    void testParity() {
        final long[] nums = new long[]{5L, 8L, 17L, 999L, 1L};
        for (final long num : nums) {
            System.out.printf("Num=[%d], Binary=[%s], [Parity=%d]%n", num, Long.toBinaryString(num),
                              ComputeParity.parityOptimised(num));
        }
    }
}
