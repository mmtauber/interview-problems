package com.radar.interview.string;

import com.radar.interview.InterviewProblem;

/**
 * @author mtauber
 *
 * Reverse words in a string. Delimited by a space. Use O(1) space
 *
 */
public class ReverseWords implements InterviewProblem {

    public void reverseWords(String input) {

        System.out.print(input + ": ");

        input = new StringBuilder(input).reverse().toString();

        int i = 0;

        while (i < input.length()) {
            int start = i;

            // Scan all chars we see until we see a space.
            while (input.charAt(i) != ' ') {
                i++;
            }

            input = input.replace(input.substring(start, i - 1),
                    new StringBuilder(input.substring(start, i - 1)).reverse().toString());

        }

        System.out.print(input + '\n');

    }

    @Override
    public void runExample() {
        reverseWords("socks dogs");
    }
}
