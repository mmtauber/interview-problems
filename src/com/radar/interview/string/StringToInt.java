package com.radar.interview.string;

import com.radar.interview.InterviewProblem;

/**
 * @author mtauber
 */
public class StringToInt implements InterviewProblem {

    public void stringToInt(String number) {

        int i = number.length() - 1;
        int magnitude = 0;
        int answer = 0;
        boolean isNeg = false;

        while (i >= 0) {

            switch (number.charAt(i)) {
                case '-':
                    isNeg = true;
                    break;
                case '0':
                    break;
                case '1':
                    answer += 1 * Math.pow(10, magnitude);
                    break;
                case '2':
                    answer += 2 * Math.pow(10, magnitude);
                    break;
                case '3':
                    answer += 3 * Math.pow(10, magnitude);
                    break;
                case '4':
                    answer += 4 * Math.pow(10, magnitude);
                    break;
                case '5':
                    answer += 5 * Math.pow(10, magnitude);
                    break;
                case '6':
                    answer += 6 * Math.pow(10, magnitude);
                    break;
                case '7':
                    answer += 7 * Math.pow(10, magnitude);
                    break;
                case '8':
                    answer += 8 * Math.pow(10, magnitude);
                    break;
                case '9':
                    answer += 9 * Math.pow(10, magnitude);
                    break;
            }
            i--;
            magnitude++;
        }

        System.out.println("Answer is: " + (isNeg ? answer * -1 : answer ));

    }

    public void intToString(int[] array, int value) {

        System.out.print("\nARRAY BEFORE: ");
        for (int p = 0; p < array.length; p++) {
            System.out.print(array[p] + " ");
        }
        System.out.print("\n");


        System.out.print("\nARRAY AFTER:  ");
        for (int q = 0; q < array.length; q++) {
            System.out.print(array[q] + " ");
        }

    }

    @Override
    public void runExample() {
        stringToInt("1233");
        stringToInt("-1002");
        stringToInt("100100100");

    }
}
