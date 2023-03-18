package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch01_javaFundamentals;

public class Power {

    public static double powerUsingApi(final double x, final int y) {
        return Math.pow(x, y);
    }

    public static double power(double x, final int y) {
        double result = 1D;
        long pow = y;

        // when y is negative => replace x by 1/x and y with -y
        if (y < 0) {
            pow = -pow;
            x = 1D / x;
        }

        // when y is a power of 2 => can replace (x^2)^2, ....
        // thus, if the LSB of y is 0 => result is (x^(y/2))^2; otherwise it is (x * (x^(y/2))^2)
        while (pow != 0) {
            if ((pow & 1) != 0) { // LSB of y is not 0
                result *= x;
            }
            x *= x;
            pow >>>= 1; // right shift with 0, or it's equivalent to y/2
        }

        return result;
    }

}
