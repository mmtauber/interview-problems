package com.radar.interview.dataStructures;

import java.util.ArrayList;

/**
 * @author mtauber
 */
public class Stack<T> {

    int top = -1;
    ArrayList<T> stack = new ArrayList<>(15);

    public void push(T value) {

        this.top++;
        stack.add(top, value);

    }


    public T pop() {

        T value = stack.get(this.top);
        stack.remove(this.top);
        this.top--;

        return value;
    }

    public T peek() {

        return stack.get(top);
    }

    public boolean isEmpty() {

        return this.top == -1;
    }

    public void printBackwards() {
        if (!isEmpty()) {
            T val = this.pop();
            printBackwards();
            System.out.print(val + " ");
        }
    }
}
