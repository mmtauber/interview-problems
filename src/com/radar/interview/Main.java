package com.radar.interview;

import com.radar.interview.problem.constellation.StarGroupFinder;

public class Main {

    public static void main(String[] args) {

        boolean[][] starMap = new boolean[][] {
                new boolean[] { true, false, true },
                new boolean[] { false, false, false },
                new boolean[] { true, false, true },
                new boolean[] { false, true, false },
                new boolean[] { false, false, false },
                new boolean[] { true, true, false }
        };

        StarGroupFinder starGroupFinder = new StarGroupFinder(starMap);

        System.out.println("Total groups: " + starGroupFinder.search());
    }
}
