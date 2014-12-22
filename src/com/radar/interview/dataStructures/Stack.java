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
        //stack[this.top] = 0;
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
}
