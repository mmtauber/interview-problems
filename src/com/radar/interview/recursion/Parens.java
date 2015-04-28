package com.radar.interview.recursion;

import com.radar.interview.InterviewProblem;

/**
 * Created by radar on 3/17/15.
 */
public class Parens implements InterviewProblem {

    public void parens(int num) {
        char[] str = new char[num * 2];
        parensRecurse(num, num, str, 0);
    }

    private void parensRecurse(int open, int closed, char[] str, int count) {

        if (open < 0 || closed < 0) {
            return;
        }
        else if (open == 0 && closed == 0) {
            System.out.println(String.copyValueOf(str));
        } else {

            if (open > 0) {
                str[count] = '(';
                parensRecurse(open - 1, closed, str, count + 1);
            }

            if (closed > open) {
                str[count] = ')';
                parensRecurse(open, closed - 1, str, count + 1);
            }
        }
    }

    @Override
    public void runExample() {
        parens(3);
    }
}
