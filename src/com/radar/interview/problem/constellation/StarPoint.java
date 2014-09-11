package com.radar.interview.problem.constellation;

/**
 * Created by mark on 9/9/14.
 */
public class StarPoint {

    private boolean isAStar = false;

    public StarPoint() {
        // Empty
    }

    public StarPoint(boolean isAStar) {
        this.isAStar = isAStar;
    }

    public boolean hasAStar() {
        return isAStar;
    }

    public void setAStar(boolean isAStar) {
        this.isAStar = isAStar;
    }
}
