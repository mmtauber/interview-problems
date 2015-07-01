package com.radar.interview.array;

import com.radar.interview.InterviewProblem;

import java.util.List;

/**
 * Created by radar on 5/12/15.
 */
public class WaterFlow implements InterviewProblem {

    public List<Point> pointsThatReachBoth() {

        return null;
    }

    private class Point{
        int x;
        int y;
        int height;
        boolean atlantic = false;
        boolean pacific = false;
        boolean visited = false;

        Point (int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        Point (int height) {
            this.height = height;
        }
    }

    @Override
    public void runExample() {

        int[][] water = { {1, 2, 2, 3, 5},
                          {3, 2, 3, 4, 4},
                          {2, 4, 5, 3, 1},
                          {6, 7, 1, 4, 5},
                          {5, 1, 1, 2, 4} };

    }
}
