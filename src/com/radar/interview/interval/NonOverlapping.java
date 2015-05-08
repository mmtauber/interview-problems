package com.radar.interview.interval;

import com.radar.interview.InterviewProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by radar on 5/7/15.
 *
 * Return the set of intervals that do not overlap with any other intervals.
 *
 */
public class NonOverlapping implements InterviewProblem {

    public List<Interval> process(List<Interval> list) {

        if (list == null || list.size() == 0) {
            return null;
        }

        if (list.size() == 1) {
            return list;
        }

        List<Interval> results = new ArrayList<>();

        // Sort by start time
        Collections.sort(list);

        // Two points: i and j.
        // Only move 'i' forward when 'j' has a greater end time.
        // Continue moving 'j' forward
        int i = 0;
        int j = 1;

        while (j < list.size()) {

            Interval first = list.get(i);
            Interval second = list.get(j);

            if (first.end > second.end) {
                j++;
                continue;
            } else {

                if (first.end <= second.start) {
                    if (j - i == 1) {
                        results.add(first);
                    }
                    if (j == list.size() - 1) {
                        results.add(second);
                    }
                }
                i++;
                j++;
            }
        }

        return results;
    }

    private class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval interval) {

            if (this.start < interval.start) {
                return -1;
            } else if (this.start > interval.start) {
                return 1;
            } else if (this.start == interval.start) {
                return Integer.compare(this.end, interval.end);
            }

            return 0;
        }
    }

    @Override
    public void runExample() {

        List<Interval> list = new ArrayList<>();
        list.add(new Interval(2, 3));
        list.add(new Interval(2, 4));
        list.add(new Interval(2, 2));
        list.add(new Interval(4, 7));
        list.add(new Interval(1, 2));
        list.add(new Interval(0, 6));

        list = process(list);

        for (Interval interval : list) {
            System.out.println("(" + interval.start + ", " + interval.end + ")");
        }


    }
}
