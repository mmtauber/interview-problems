package com.radar.interview.array;

import com.radar.interview.InterviewProblem;

/**
 * Created by radar on 4/28/15.
 * 
 * Find the single maximum or minimum in a given array in O(1) time. 
 * 
 */
public class FindLocalMaxMin implements InterviewProblem {
    
    public int findLocalMaxMin(int[] array) {

        int val1 = array[0] + (array[ array.length -1 ] + array.length - array[0])/2;
                // 10 + (11 + 6 - 10) / 2
                // 10 + 7 / 2 = 10 + 3.5 = 10 + 3 = 13

        int val2 = array[0] - (array[ array.length -1 ] + array.length - array[0])/2;
                // 10 - 7 / 2 = 1.5


        return  array[0] > array[1] ? val2 : val1;
    }
    
    @Override
    public void runExample() {
        int[] array = { 10, 11, 12, 13, 12, 11};
        int[] array2 = { 5, 4, 3, 2, 3, 5};
        int[] array3 = { 1, 2, 1, 2, 3, 4};

        System.out.println(findLocalMaxMin(array));
        System.out.println(findLocalMaxMin(array2));
        System.out.println(findLocalMaxMin(array3));
    }
}
