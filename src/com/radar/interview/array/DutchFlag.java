package com.radar.interview.array;

/**
 * @author mtauber
 */
public class DutchFlag {

    int[] array;
    int lowIndex;
    int highIndex;

    public int[] arrange(int[] array, int pivot) {

        this.array = array;
        lowIndex = 0;

        // High index is equal pivot plus one unless the pivot is at the end of
        // the array, then it is equal to the pivot.
        highIndex = ( pivot == array.length - 1 ? pivot : pivot + 1 );

        int pivotVal = array[pivot];

        for (int i = 0; i < array.length; i++) {

            if (array[lowIndex] < pivotVal) {
                lowIndex++;
                continue;
            } else if (array[lowIndex] > pivotVal) {
                swap(lowIndex, highIndex);
                lowIndex++;
                highIndex++;
                continue;
            } else if (array[lowIndex] == pivotVal) {
                
            }

        }


        return new int[1];
    }

    private void swap(int i, int j) {
        int temp;

        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
