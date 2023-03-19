package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch01_javaFundamentals;

import org.junit.jupiter.api.Test;

public class ComputeParityTest {

    @Test
    void testParity() {
        final var nums = new long[]{5L, -8L, 17L, 999L, 1L};
        for (final var num : nums) {
            System.out.printf("Num=[%d], Binary=[%s], BitCount=[%d], [parityUsingApi=%d], [parity=%d], [parityOptimised=%d]%n",
                              num,
                              Long.toBinaryString(num),
                              Long.bitCount(num),
                              ComputeParity.parityUsingApi(num),
                              ComputeParity.parity(num),
                              ComputeParity.parityOptimised(num));
        }
    }

}
