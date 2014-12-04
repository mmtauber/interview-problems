package com.radar.infinity_zero.array;

import com.radar.infinity_zero.InterviewProblem;

/**
 * @author mtauber
 *
 * Values in the array represent how much effort the 'robot' needs to
 * exert to climb. The robot regenerates on the downhills. Find the
 * minimum battery capacity to traverse the points.
 *
 */
public class RobotBattery implements InterviewProblem {

    int[] array;

    // ASSUMES A SORTED ARRAY
    public void calcMinimumBattery(int[] array) {

        this.array = array;

        System.out.print("\nARRAY: ");
        for (int p = 0; p < array.length; p++) {
            System.out.print(array[p] + " ");
        }
        System.out.print("\n");

        int index = 0;
        int biggestDiff = 0;
        int diff;

        while (index < array.length - 1) {

            diff = array[index + 1] - array[index];

            biggestDiff = ( diff > biggestDiff ? diff : biggestDiff);
            index++;

        }

        System.out.print("\nMinimum battery capacity: " + biggestDiff);

    }

    @Override
    public void runExample() {
        int[] testArray = new int[]{ 0, 5, 3, 9 };
        new RobotBattery().calcMinimumBattery(testArray);
    }
}
