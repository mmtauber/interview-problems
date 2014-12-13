package com.radar.interview.bits.tenMillionBits;

import com.radar.interview.InterviewProblem;

import java.util.Random;

/**
 * @author mtauber
 *
 * "Sort 10 million 10-bit integers in O(n) time."
 *
 */
public class TenMillionBits implements InterviewProblem {

    // Assumes we receive no numbers greater than 1023 or less than zero.
    public void sort(short[] nums) {

        short[] sortedNums = new short[1024];

        for (short num : nums) {
            sortedNums[num] += 1;
        }

        for (int j = 0; j < sortedNums.length; j++) {
            System.out.println(String.format("Number of %ds: %d", j, sortedNums[j]));
        }
    }

    private short[] generateArray(int size) {

        short[] array = new short[size];

        Random randomGenerator = new Random();
        for (int idx = 0; idx < size; ++idx){
            array[idx] = (short) randomGenerator.nextInt(1024);
        }

        return array;
    }

    @Override
    public void runExample() {
        sort(generateArray(10000000));
    }
}
