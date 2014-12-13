package com.radar.interview.array;

import com.radar.interview.InterviewProblem;

/**
 * @author mtauber
 *
 * LONGEST SUB ARRAY
 *
 * Find the beginning and ending index of the longest increasing sub array.
 * Example: Given the array [ 5, 7, 3, 6, 11, 6, 17 ] the longest sub array
 * is [ 3, 6, 11 ] so the method returns [ 2, 4 ].
 *
 *
 */
public class LongestSubArray implements InterviewProblem {

    int[] array;

    // ASSUMES A SORTED ARRAY
    public void findLongestSubArray(int[] array) {

        this.array = array;
        int[] answer = new int[] { 0, 0 };

        System.out.print("\nARRAY BEFORE: ");
        for (int p = 0; p < array.length; p++) {
            System.out.print(array[p] + " ");
        }
        System.out.print("\n");

        // Track the lowest number, i, and the highest number, j
        int low = 0;

        for (int k = 0; k < array.length - 1; k++) {

            // If the next number is higher increment the highest index, otherwise,
            // check the current sub array length, if it's greater than what we have
            // update it.
            if (array[k] < array[k + 1] ) {
                continue;
            } else {

                if ( (k - low) > (answer[1] - answer[0]) ) {
                    answer[0] = low;
                    answer[1] = k;
                    low = k;
                } else {
                    low = k + 1;
                }

            }
        }

        System.out.print("\n\nLongest sub array between these indices: { " + answer[0] +
                                                    ", " + answer[1] + " }.");
    }

    @Override
    public void runExample() {
        int[] testArray = new int[]{ 2,4,5,9,12,13,14,15,16};
        new LongestSubArray().findLongestSubArray(testArray);
    }
}
