package com.radar.interview.problem.constellation;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by mark on 9/9/14.
 */
public class StarGroupFinder {

    private int total = 0;

    private StarPoint[][] map;

    private HashMap<UUID, StarPoint> seenMap = new HashMap<UUID, StarPoint>();

    public StarGroupFinder(StarPoint[][] map) {
        this.map = map;
    }


    public int search() {

        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[0].length; j++) {

                inspect(i, j, false);

            }
        }

        return total;
    }

    private void inspect(int xPosOnMap, int yPosOnMap, boolean fromConnection) {

        StarPoint starPoint = map[xPosOnMap][yPosOnMap];

        // Have we seen this point yet? If so, no need to inspect again.
        if ( ! seenMap.containsValue(starPoint)) {

            seenMap.put(UUID.randomUUID(), starPoint);

            // Does it have a star?
            if (starPoint.hasAStar()) {

                int x = xPosOnMap;
                int y = yPosOnMap;

                int lowEndX = (x - 1);
                int lowEndY = (y - 1);

                int highEndX = (1 + x);
                int highEndY = (1 + y);


                for (int p = lowEndX; p <= highEndX; p++ ) {
                    for (int q = lowEndY; q <= highEndY; q++ ) {

                        // Do not investigate the cell if:
                        //      X and Y equal the origin of the search
                        //      X and/or Y are less than zero (out of bounds)
                        //      X and/or are equal to the max length (out of bounds)

                        if ( p < map.length &&
                             q < map[0].length &&
                             !(p == x && q == y) &&
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
        }
    }




    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public HashMap<UUID, StarPoint> getSeenMap() {
        return seenMap;
    }

    public void setSeenMap(HashMap<UUID, StarPoint> seenMap) {
        this.seenMap = seenMap;
    }
}
