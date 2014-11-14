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

    public void lookAndSay(final String input, int iter, int current) {

        if (current == iter) {
            return;
        }

        if (input.length() == 1) {
            System.out.print("LOOK AND SAY: 1" + input + '\n');
            lookAndSay("1" + input, iter, current + 1);
        } else {
            int count = 1;
            String answer = "";
            for (int i = 0; i < input.length(); i++) {
                while (i + 1 < input.length() && input.charAt(i + 1) == input.charAt(i)) {
                    count++;
                    i++;
                }

                answer = answer + count + input.charAt(i);
                // Reset count
                count = 1;
            }
            System.out.print("LOOK AND SAY: " + answer + '\n');
            lookAndSay(answer, iter, current + 1);
        }

    }

    @Override
    public void runExample() {
        lookAndSay("3", 8, 0);
    }
}
