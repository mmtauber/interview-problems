package com.radar.interview.string;

import com.radar.interview.InterviewProblem;

/**
 * @author mtauber
 *
 * Write a function which takes as input a string 's', and removes each 'b'
 * and replaces each 'a' with 'dd'. Use O(1) additional storage. Assume 's' is stored in
 * an array that has enough space for the final result.
 *
 */
public class ReplaceRemove implements InterviewProblem {

    public void replaceRemove(char[] input) {

        System.out.println("Answer is: ");
    }

    //
    public void shift(int indicesToShift, int startIndex, char[] input) {

        for (int i = startIndex; i >= 0 || i < input.length; i++) {

            // If current index is 'b' shift any remaining elements back 1 index.
            if (input[startIndex] == 'b') {

                while (startIndex < input.length) {
                    input[startIndex] = input[startIndex + 1];
                    startIndex++;
                }
            }

            else if (input[startIndex] == 'a') {

                input[startIndex] = 'd';
                input[startIndex + 1] = 'd';
                startIndex += 2;
                i++;

                while (startIndex < input.length) {
                    input[startIndex] = input[startIndex + 1];
                    startIndex++;
                }
            }
        }
    }

    @Override
    public void runExample() {
        char[] example = { 'a', 'c', 'a', 'b', 'b', 'a', 'c', 'c'};
    }
}
