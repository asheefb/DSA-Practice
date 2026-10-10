package LeetCode.Stack;

/*
https://leetcode.com/problems/min-stack/
 */

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        stack.push(value);

        if (minStack.isEmpty())
            minStack.push(value);
        else
            minStack.push(Math.min(minStack.peek(), value));
    }

    public void pop() {
        stack.pop();

        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
