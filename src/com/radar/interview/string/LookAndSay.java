package com.radar.interview.string;

import com.radar.interview.InterviewProblem;

/**
 * @author mtauber
 *
 * Look and say. Given '1', the first look and say is "one one", which translates to
 * the number '11'
 *
 */
public class LookAndSay implements InterviewProblem {

    public void lookAndSay(StringBuilder input, int iter) {

        int current = 0;
        int count = 1;

        if (input == null | input.length() == 0) {
            return;
        }

        while (current != iter) {

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                while (i + 1 < input.length() && input.charAt(i + 1) == input.charAt(i)) {
                    count++;
                    i++;
                }

                answer.append(count).append(input.charAt(i));
                // Reset count
                count = 1;
            }
            System.out.print("LOOK AND SAY: " + answer + '\n');
            current++;
            input = answer;
        }
    }

    @Override
    public void runExample() {
        lookAndSay(new StringBuilder("1"), 5);
    }
}
