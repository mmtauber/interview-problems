package com.radar.interview.regex;

import com.radar.interview.InterviewProblem;

/**
 * Created by radar on 4/27/15.
 *
 * Original code by Rob Pike, 1998
 *
 */
public class RegexMatcher implements InterviewProblem {

    public int match(char[] regex, char[] text) {

        int i = 0;
        int j = 0;

        if (regex[0] == '^') {
            return matchHere(regex, text, i + 1, j);
        }

        do {
            if (matchHere(regex, text, i, j) == 1) {
                return 1;
            }
        } while (j++ < text.length);

        return 0;
    }

    public int matchHere(char[] regex, char[] text, int i, int j) {

        if (i == regex.length) {
            return 1;
        }

        if (i + 1 < regex.length && regex[i + 1] == '*') {
            return matchStar(regex[i], regex, text, i + 2, j);
        }

        if (regex[i] == '$' && regex[i + 1] == regex.length) {
            return j == text.length ? 1 : 0;
        }

        if (j < text.length && (regex[i] == '.' || regex[i] == text[j])) {
            return matchHere(regex, text, i + 1, j + 1);
        }

        return 0;
    }

    public int matchStar(char c, char[] regex, char[] text, int i, int j) {

        do {
            if (matchHere(regex, text, i, j) == 1) {
                return 1;
            }
        } while ( j < text.length && (text[j++] == c || c == '.'));

        return 0;
    }


    @Override
    public void runExample() {
        System.out.println(match(".bc".toCharArray(), "qbc".toCharArray()));
    }
}
