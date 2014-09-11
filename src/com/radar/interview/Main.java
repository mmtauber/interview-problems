package com.radar.interview;

import com.radar.interview.problem.constellation.StarGroupFinder;
import com.radar.interview.problem.constellation.StarPoint;

public class Main {

    public static void main(String[] args) {

        StarPoint[][] starMap = new StarPoint[][] {
                new StarPoint[] { new StarPoint(true), new StarPoint(), new StarPoint(true) },
                new StarPoint[] { new StarPoint(), new StarPoint(true), new StarPoint() },
                new StarPoint[] { new StarPoint(true), new StarPoint(), new StarPoint(true) }
        };

        StarGroupFinder starGroupFinder = new StarGroupFinder(starMap);

        System.out.println("Total groups: " + starGroupFinder.search());
    }
}
