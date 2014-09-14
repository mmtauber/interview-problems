package com.radar.interview.bits.parity;

/**
 * @author mtauber
 */
public class BitParity {

    public static boolean isOddParity(int num) {
        int bitCount = 0;

        for (int i = 0; i < 32; i++, num >>>= 1) {
            if ( (num & 1) != 0) {
                bitCount++;
            }
        }

        return ( bitCount & 1 ) != 0;
    }
}
