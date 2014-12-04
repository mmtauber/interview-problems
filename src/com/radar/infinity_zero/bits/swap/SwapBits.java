package com.radar.infinity_zero.bits.swap;

import com.radar.infinity_zero.InterviewProblem;

/**
 * @author mtauber
 */
public class SwapBits implements InterviewProblem {

    public void swapBits(long number, byte i, byte j) {

        // Test for non-zero bits at indices
        boolean iBitIsOne = ((number >> i) & 1) == 1;
        boolean jBitIsOne = ((number >> j) & 1) == 1;

        boolean shouldSwap = iBitIsOne ^ jBitIsOne;

        if (!shouldSwap) {
            System.out.println(String.format("Swapping bits are equal. The number doesn't change: %d", number));
            return;
        }

        long iMask = 1 << i;
        long jMask = 1 << j;

        if (iBitIsOne) {
            
        }

        long mask = (long) (iBitIsOne ? 1 << j : 1 << i);

        System.out.println(String.format("Swapping bits at %d and %d for %d. Using mask: %d\n\nProduces: %d",
                i, j, number, mask, number ^ mask));

    }

    @Override
    public void runExample() {
        swapBits(128L, (byte) 0x07, (byte) 0x00);
    }
}
