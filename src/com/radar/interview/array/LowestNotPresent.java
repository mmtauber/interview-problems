package com.radar.interview.array;

import com.radar.interview.InterviewProblem;

/**
 * @author mtauber
 *
 * Find the lowest postive number not present in the array.
 *
 * MISUNDERSTOOD BOOK PROBLEM. THIS NASWER IS NOT VALID.
 *
 */
public class LowestNotPresent implements InterviewProblem {

    int[] array;

    public void findLowestNotPresent(int[] array) {

        this.array = array;

        System.out.print("\nARRAY: ");
        for (int p = 0; p < array.length; p++) {
            System.out.print(array[p] + " ");
        }
        System.out.print("\n");
        
        int lowest = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                continue;
            }
            if (lowest > array[i]) {
                lowest = array[i];
            }
        }

        int answer = (lowest == 1 ? 0 : lowest - 1);

        System.out.print("\nLowest not present: " + answer);

    }

    @Override
    public void runExample() {
        int[] testArray = new int[]{ 3, 4, 0 ,2 };
        new LowestNotPresent().findLowestNotPresent(testArray);
    }
}
