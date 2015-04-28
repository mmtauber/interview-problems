package com.radar.interview.recursion;

import com.radar.interview.InterviewProblem;

import java.util.ArrayList;

/**
 * Created by radar on 3/17/15.
 *
 * Return all subsets of a set including the empty set.
 *
 */
public class Subsets implements InterviewProblem {

    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;

        if (set.size() == index) {
            allsubsets = new ArrayList<>();
            allsubsets.add(new ArrayList<Integer>());
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();

            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }

            allsubsets.addAll(moresubsets);
        }

        return allsubsets;
    }

    @Override
    public void runExample() {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(0);
        set.add(1);
        set.add(2);
        getSubsets(set, 0);

    }
}
