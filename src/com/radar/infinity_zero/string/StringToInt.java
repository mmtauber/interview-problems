package com.radar.infinity_zero.string;

import com.radar.infinity_zero.InterviewProblem;

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

    public void intToString(int value) {

        StringBuilder answer = new StringBuilder();
        
        boolean isNeg = ( value < 0 );

        while (value != 0) {

            switch (Math.abs(value % 10)) {
                case 0:
                    answer.insert(0, '0');
                    break;
                case 1:
                    answer.insert(0, '1');
                    break;
                case 2:
                    answer.insert(0, '2');
                    break;
                case 3:
                    answer.insert(0, '3');
                    break;
                case 4:
                    answer.insert(0, '4');
                    break;
                case 5:
                    answer.insert(0, '5');
                    break;
                case 6:
                    answer.insert(0, '6');
                    break;
                case 7:
                    answer.insert(0, '7');
                    break;
                case 8:
                    answer.insert(0, '8');
                    break;
                case 9:
                    answer.insert(0, '9');
                    break;
            }
            value = value / 10;
        }

        System.out.println("Answer is: " + ( isNeg ? answer.insert(0, '-').toString() :
                                            answer.toString()));
    }

    @Override
    public void runExample() {
        stringToInt("1233");
        stringToInt("-1002");
        stringToInt("100100100");

        intToString(100034);
        intToString(-100034);
        intToString(1112109000);
    }
}
