package com.radar.interview.stack;

import com.radar.interview.InterviewProblem;

/**
 * @author mtauber
 *
 * Code PbbMatch notation
 *
 */
public class RPN implements InterviewProblem {

    /*public void RPN() {

        Stack stack = new Stack();
        stack.rpnPush("5");
        stack.rpnPush("1");
        stack.rpnPush("2");
        stack.rpnPush("+");
        stack.rpnPush("4");
        stack.rpnPush("x");
        stack.rpnPush("+");
        stack.rpnPush("3");
        stack.rpnPush("-");

        System.out.print("\nANSWER: " + stack.peek());

    }

    public <T extends Number> void rpnPush(T value) {

        T temp1, temp2;

        switch (value.toString()) {
            case "+":
                temp1 = this.pop();
                temp2 = this.pop();
                this.push(temp2 + temp1);
                break;
            case "-":
                temp1 = this.pop();
                temp2 = this.pop();
                this.push(temp2 - temp1);
                break;
            case "x":
                temp1 = this.pop();
                temp2 = this.pop();
                this.push(temp2 * temp1);
                break;
            case "/":
                temp1 = this.pop();
                temp2 = this.pop();
                this.push(temp2 / temp1);
                break;
            default :
                this.push(Integer.valueOf(value));
        }


    }*/


    @Override
    public void runExample() {


        //RPN();
    }
}
