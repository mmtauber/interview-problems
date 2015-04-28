package com.radar.interview.search;

import com.radar.interview.InterviewProblem;

/**
 * Created by radar on 4/21/15.
 *
 * Recursive binary search.
 *
 * Assumes a sorted array!
 *
 */
public class BinarySearch implements InterviewProblem {

    public int binarySearch(int[] array, int num) {

        return binarySearchHelp(array, num, 0, array.length - 1);
    }

    private int binarySearchHelp(int[] array, int num, int lo, int hi) {
        if (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (array[mid] == num) {
                return mid;
            } else if (array[mid] > num) {
                return binarySearchHelp(array, num, lo, mid - 1);
            } else {
                return binarySearchHelp(array, num, mid + 1, hi);
            }
        }
        return -1;
    }

    @Override
    public void runExample() {
            int[] array = {2, 5, 6, 8, 11, 14, 16, 19, 222};
            System.out.println(binarySearch(array, 222));
    }
}
