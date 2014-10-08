package com.radar.interview.array;

import com.radar.interview.InterviewProblem;

/**
 * @author mtauber
 */
public class RemoveOccurences implements InterviewProblem {

    int[] array;

    public void remove(int[] array, int value) {

        this.array = array;

        System.out.print("\nARRAY BEFORE: ");
        for (int p = 0; p < array.length; p++) {
            System.out.print(array[p] + " ");
        }
        System.out.print("\n");
        

        int i = 0;
        int j = array.length - 1; // Define variable to be a point to the end of the array

        // Loop until we meet the pointer coming from the back of the array.
        while (i < j) {
            if (array[i] == value) {
                array[i] = -1;
                swap(i, j);
                j--;
            } else {
                i++;
            }
        }

        System.out.print("\nARRAY AFTER:  ");
        for (int q = 0; q < array.length; q++) {
            System.out.print(array[q] + " ");
        }
        System.out.print("\n\nElements leftover: " + i);

    }

    /**
     * Swap values at the provided *indices*.
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        int temp;

        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public void runExample() {
        int[] testArray = new int[]{ 9, 9, 3, 6, 9, 6, 9, 3, 9, 3, 6, 3, 3 };
        new RemoveOccurences().remove(testArray, 3);
    }
}
