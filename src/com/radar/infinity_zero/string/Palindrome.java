package com.radar.infinity_zero.string;

import com.radar.infinity_zero.InterviewProblem;

/**
 * @author mtauber
 *
 * Implement a function that takes string input and determines if it is a palindrome.
 * Assumes all nonalphanumeric are removed.
 *
 */
public class Palindrome implements InterviewProblem {

    public void testPalindrome(String input) {

        boolean isPalindrome = false;

        int i = 0;
        int j = input.length() - 1;

        if (input.isEmpty()) {
            isPalindrome = false;
        }

        if (input.length() == 1) {
            isPalindrome = true;
        }

        while (i < j) {

            if (input.charAt(i) == input.charAt(j)) {
                i++;
                j--;
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }

        }

        System.out.println(input + ": " + isPalindrome);

    }

    @Override
    public void runExample() {
        testPalindrome("dad");
        testPalindrome("oooo");
        testPalindrome("shitcakes");
        testPalindrome("fart knocker");
        testPalindrome("racecar");
        testPalindrome("a");
        testPalindrome("");
        testPalindrome("bb");
    }
}
