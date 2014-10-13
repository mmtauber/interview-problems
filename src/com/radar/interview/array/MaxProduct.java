package com.radar.interview.array;

import com.radar.interview.InterviewProblem;

/**
 * @author mtauber
 *
 * Given an array of floating point numbers calculate the highest possible
 * product while using n-1 elements, where n is the length of the array.
 *
 */
public class MaxProduct implements InterviewProblem {

    double[] array;

    // ASSUMES A SORTED ARRAY
    public void calcMaxProduct(double[] array) {

        this.array = array;

        System.out.print("\nARRAY: ");
        for (int p = 0; p < array.length; p++) {
            System.out.print(array[p] + " ");
        }
        System.out.print("\n");

        // What is the lowest number in the array?
        double lowestNumberIndex = 0;

        // Does the array have at least one zero?
        double total = 1;

        // Gather array data
        for (int i = 0; i < array.length; i++) {

            // Keep track of our lowest number
            if (array[i] < lowestNumberIndex) {
                lowestNumberIndex = array[i];
            }
        }

        // TODO: Track number of negatives
        // If odd, keep zero .l
        // Even, remove zero.


        // Calculate product
        for (int j = 0; j < array.length; j++) {
            if (j == lowestNumberIndex) {
                continue;
            }

            total *= array[j];
        }

        System.out.print("\nMax product found: " + total);

    }

    @Override
    public void runExample() {
        double[] testArray = new double[]{ 3, 3, -1, -1 };
        new MaxProduct().calcMaxProduct(testArray);
    }
}
