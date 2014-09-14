package com.radar.interview.bits.parity;

/**
 * @author mtauber
 */
public class BitParity {

    public static boolean isOddParity(int num) {
        boolean isOdd = false;

        while (num != 0) {

            // Check LSB
            if ( (num & 1) != 0) {
                isOdd = !isOdd;
            }

            // Shift current LSB out
            num >>>= 1;

        }

        return isOdd;
    }
}
