package com.radar.interview.array;

/**
 * @author mtauber
 */
public class DutchFlag {

    int[] array;
    int lowIndex = 0;
    int midIndex = 0;
    int highIndex;

    public int[] arrange(int[] array, int pivot) {

        this.array = array;

        highIndex = array.length - 1;

        int pivotVal = array[pivot];

        for (int i = 0; i < array.length; i++) {



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
