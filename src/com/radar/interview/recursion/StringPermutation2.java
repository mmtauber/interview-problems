package com.radar.interview.recursion;

import com.radar.interview.InterviewProblem;

/**
 * Created by radar on 4/28/15.
 */
public class StringPermutation2 implements InterviewProblem {

    public void permute(String str) {
        boolean[] used = new boolean[str.length()];
        StringBuilder out = new StringBuilder();
        char[] in = str.toCharArray();

        permuteHelp(in, out, used, str.length(), 0);
    }

    public void permuteHelp(char[] in, StringBuilder out, boolean[] used, int length, int level) {

        if (level == length) {
            System.out.println(out.toString());
            return;
        }

        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }

            out.append(in[i]);
            used[i] = true;

            // We could modify and not recurse if we are at the end of a permutation.
            // if ( level + 1 == length ) { print & return }
            permuteHelp(in, out, used, length, level + 1);
            used[i] = false;
            out.setLength( out.length() - 1 );
        }

    }

    @Override
    public void runExample() {

    }
}
