package com.radar.infinity_zero.array;

import com.radar.infinity_zero.InterviewProblem;

/**
 * @author mtauber
 */
public class DutchFlag implements InterviewProblem {

    int[] array;
    int lowIndex = 0;
    int midIndex = 0;
    int highIndex;

    public void arrange(int[] array, int pivot) {

        this.array = array;

        highIndex = array.length - 1;

        int pivotVal = array[pivot];

        System.out.print("\nARRAY BEFORE: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        while (midIndex < array.length) {

            // If the high index has met the mid index we can exit earlier
            if (highIndex < midIndex) {
                    break;
            }

            if (array[midIndex] < pivotVal) {
                swap(lowIndex, midIndex);
                lowIndex++;
                midIndex++;
            } else if (array[midIndex] > pivotVal) {
                swap(midIndex, highIndex);
                highIndex--;
            } else {
                midIndex++;
            }
        }

        System.out.print("\nARRAY AFTER: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }

    private void swap(int i, int j) {
        int temp;

        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public void runExample() {
        int[] testArray = new int[]{ 9, 9, 3, 6, 9, 6, 9, 3, 9, 3, 6, 3, 3 };
        new DutchFlag().arrange(testArray, 3);
    }
}
