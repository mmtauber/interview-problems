package com.radar.interview.constellation;

import com.radar.interview.InterviewProblem;

/**
 * Created by mark on 9/9/14.
 */
public class StarGroupFinder implements InterviewProblem {

    private int total = 0;

    private boolean[][] map;

    private boolean[][] seenMap;

    public StarGroupFinder(boolean[][] map) {
        this.map = map;
    }


    public int search() {

        if (map == null || map.length <= 0 || map[0].length < 0) {
            throw new IllegalArgumentException("WTF.");
        }

        int lengthForX = map.length;
        int lengthForY = map[0].length;

        // Init seenMap with 'false'
        // **boolean primitive defaults to 'false'
        seenMap = new boolean[lengthForX][lengthForY];

        for (int i = 0; i < lengthForY; i++) {
            seenMap[i] = new boolean[lengthForY];
        }

        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[0].length; j++) {

                inspect(i, j, false);

            }
        }

        return total;
    }

    private void inspect(int xPosOnMap, int yPosOnMap, boolean fromConnection) {

        boolean starPoint = map[xPosOnMap][yPosOnMap];

        // Have we seen this point yet? If so, return.
        if (seenMap[xPosOnMap][yPosOnMap]) {
            return;
        }

        seenMap[xPosOnMap][yPosOnMap] = true;

        // If there is no star here skip inspection logic.
        if ( ! starPoint) {
            return;
        }

        int lowEndX = (xPosOnMap - 1);
        int lowEndY = (yPosOnMap - 1);

        int highEndX = (1 + xPosOnMap);
        int highEndY = (1 + yPosOnMap);


        for (int p = lowEndX; p <= highEndX; p++ ) {
            for (int q = lowEndY; q <= highEndY; q++ ) {

                // Do not investigate the cell if:
                //      X and Y equal the origin of the search
                //      X and/or Y are less than zero (out of bounds)
                //      X and/or are equal to the max length (out of bounds)

                if ( p < map.length &&
                     q < map[0].length &&
                     !(p == xPosOnMap && q == yPosOnMap) &&
                     p >= 0 &&
                     q >= 0 ) {

                    inspect(p, q, true);
                }
            }
        }

        // Test if we are in a recursive iteration.
        // Only add to total from non-recursive iterations.
        total = ( fromConnection ? total : total + 1 );
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public void runExample() {
        boolean[][] starMap = new boolean[][] {
                 { true, false, true },
                 { false, false, false },
                 { true, false, true },
                 { false, true, false },
                 { false, false, false },
                 { true, true, false }
        };

        StarGroupFinder starGroupFinder = new StarGroupFinder(starMap);

        System.out.println("Total groups: " + starGroupFinder.search());
    }
}
