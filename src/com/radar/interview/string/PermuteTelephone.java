package com.radar.interview.string;

import com.radar.interview.InterviewProblem;

/**
 * @author mtauber
 *
 * Return all possible char sequences corresponding to the phone number.
 *
 */
public class PermuteTelephone implements InterviewProblem {

    int count = 0;
    String[] keypad = new String[]{ "0", "1", "ABC", "DEF",
            "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public void permuteTelephone(final String input) {

        helper(input, 0, new char[input.length()]);
        System.out.print("TOTAL PERMUTATIONS: " + count + '\n');
    }

    public void helper(String input, int level, char[] ans) {
        if (level == input.length()) {
            count++;
            System.out.print("WORD: " + String.valueOf(ans) + '\n');
        } else {

            for (final char c : keypad[input.charAt(level) - '0'].toCharArray()) {
                ans[level] = c;
                helper(input, level + 1, ans);
            }
        }
    }

    @Override
    public void runExample() {
        permuteTelephone("480243577");
    }
}
