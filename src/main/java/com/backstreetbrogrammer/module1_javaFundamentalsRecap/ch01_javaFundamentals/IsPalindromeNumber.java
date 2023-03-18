package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch01_javaFundamentals;

public class IsPalindromeNumber {

    public static boolean isPalindromeNumber(int num) {
        if (num < 0) return false;
        else if (num == 0) return true;

        // no of digits in a number
        // ex: 1234 = log10(1234) + 1 => (int) 3.091 + 1 => 4
        final int numDigits = (int) (Math.floor(Math.log10(num))) + 1;

        // most significant digit = num / (10^numDigits-1)
        // ex: 1234 / 1000 => (int) 1.234 => 1
        int msdMask = (int) Math.pow(10, numDigits - 1);

        // least significant digit = num % 10
        // ex: 1234 % 10 => 4
        for (int i = 0; i < (numDigits / 2); ++i) {
            if ((num / msdMask) != (num % 10)) { // compare msd with lsd
                return false;
            }
            num %= msdMask; // remove the most significant digit of num
            num /= 10; // remove the least significant digit of num
            msdMask /= 100; // as 2 digits are removed
        }

        return true;
    }

}
