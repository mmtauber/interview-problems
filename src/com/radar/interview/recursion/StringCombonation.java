package com.radar.interview.recursion;

import com.radar.interview.InterviewProblem;

/**
 * Created by radar on 4/28/15.
 */
public class StringCombonation implements InterviewProblem {

    public void combo(String str) {
        char[] inStr = str.toCharArray();
        StringBuilder outStr = new StringBuilder();

        comboHelp(inStr, outStr, str.length(), 0, 0);
    }

    public void comboHelp(char[] inStr, StringBuilder outStr, int length, int level, int start) {

        for (int i = start; i < length; i++) {
            outStr.append(inStr[i]);
            System.out.println(outStr.toString());

            if (i < length - 1) {
                comboHelp(inStr, outStr, length, level + 1, i + 1);
            }

            outStr.setLength(outStr.length() - 1);
        }

        /* Using loop partitioning we can eliminate the if-statement above.
            This doesn't make a huge difference here, but it is worth noting.
         */
//        int i = 0;
//        for (i = start; i < length - 1; i++) {
//            outStr.append(inStr[i]);
//            System.out.println(outStr.toString());
//
//            comboHelp(inStr, outStr, length, level + 1, i + 1);
//
//            outStr.setLength( outStr.length() - 1 );
//        }
//
//        outStr.append(inStr[i]);
//        System.out.println(outStr.toString());
//        outStr.setLength( outStr.length() - 1 );
    }

    @Override
    public void runExample() {

        combo("abc");

    }
}
