package com.radar.infinity_zero.array;

import com.radar.infinity_zero.InterviewProblem;

/**
 * @author mtauber
 *
 * ASSUMES A SORTED ARRAY
 *
 * We don't care about the number values after we have eliminated duplicates.
 *
 * A valid answer array could look like [3, 3, 6, 6, 9, 9] -> [3, 6 ,9, 6, 9]
 * We only care about the number of valid elements remaining anyways. In the above case
 * that answer is 3.
 *
 */
public class RemoveDuplicates implements InterviewProblem {

    int[] array;

    // ASSUMES A SORTED ARRAY
    public void removeDuplicates(int[] array) {

        this.array = array;

        System.out.print("\nARRAY BEFORE: ");
        for (int p = 0; p < array.length; p++) {
            System.out.print(array[p] + " ");
        }
        System.out.print("\n");

        int index = 0;

        for (int i = 1; i < array.length; i++) {

            if (array[index] != array[i]) {

                array[++index] = array[i];
            }
        }

        System.out.print("\nARRAY AFTER:  ");
        for (int q = 0; q < array.length; q++) {
            System.out.print(array[q] + " ");
        }
        System.out.print("\n\nElements leftover: " + (index + 1));

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
        int[] testArray = new int[]{ 3,3,3,6,6,6,9,9,9};
        new RemoveDuplicates().removeDuplicates(testArray);
    }
}
