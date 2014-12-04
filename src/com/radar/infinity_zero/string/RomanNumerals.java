package com.radar.infinity_zero.string;

import com.radar.infinity_zero.InterviewProblem;

/**
 * @author mtauber
 *
 * Write a function which takes as input a string of roman numerals. Return the string
 * translated in decimal.
 *
 * REFERENCE:
 * I = 1
 * V = 5
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000
 *
 */
public class RomanNumerals implements InterviewProblem {

    // If the next index is a lower value than the current index subtract the next from the current.
    // Otherwise, if each next index is a greater value than the current index simply continue adding.

    public void romanNumerals(String input) {

        System.out.println("Input is: " + input);

        int i = input.length() - 1;
        char currentChar;
        int lastValue = 0;
        int value = 0;
        int total = 0;
        boolean useAddition = true;

        while (i >= 0) {

            currentChar = input.charAt(i);

            switch(currentChar) {
                case 'I':
                    value = 1;
                    break;
                case 'V':
                    value = 5;
                    break;
                case 'X':
                    value = 10;
                    break;
                case 'L':
                    value = 50;
                    break;
                case 'C':
                    value = 100;
                    break;
                case 'D':
                    value = 500;
                    break;
                case 'M':
                    value = 1000;
                    break;
                default:
                    // Error.
                    break;
            }

            // Last operation was addition and the current value is greater or equal than the last.
            // Continue addition.
            if (useAddition && (value >= lastValue)) {
                useAddition = true;
            }
            // Last operation was subtraction and the current value is less than or equal to the last.
            // Continue subtraction.
            else if (!useAddition && (value <= lastValue)) {
                useAddition = false;
            }
            // If the current value is greater than or equal be sure to
            // Switch to addition.
            else if (value >= lastValue) {
                useAddition = true;
            }
            // Otherwise
            // Switch to subtraction.
            else {
                useAddition = false;
            }

            total = ( useAddition ? total + value : total - value);

            lastValue = value;
            i--;
        }

        System.out.println("Value in decimal is: " + total);
    }

    @Override
    public void runExample() {
        romanNumerals("MM");
        romanNumerals("MCM");
        romanNumerals("IV");
        romanNumerals("XII");
        romanNumerals("IIX");
        romanNumerals("MCCMXLIV");
    }
}
