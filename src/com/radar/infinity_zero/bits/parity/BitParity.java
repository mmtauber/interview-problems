package com.radar.infinity_zero.bits.parity;

import com.radar.infinity_zero.InterviewProblem;

/**
 * @author mtauber
 */
public class BitParity implements InterviewProblem {

    public static boolean isOddParity(int num) {
        boolean isOdd = false;

        while (num != 0) {

            // Check LSB
            if ( (num & 1) != 0) {
                isOdd = !isOdd;
            }

            // isOdd ^=  ((num & 1) == 0);

            // Shift current LSB out
            num >>>= 1;

        }

        return isOdd;
    }

    @Override
    public void runExample() {
        System.out.println("Bit parity is odd? " + BitParity.isOddParity(1));
    }
}
