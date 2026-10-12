package LeetCode.Stack;

/*
https://leetcode.com/problems/min-stack/
 */

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    //push
    //encodedValue = 2 * value - min;

    // recover
    //Previous minimum = 2 × current minimum - encoded value

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

    /*
        Second Approach
            Stack<Long> stack = new Stack<>();
            long min;

            public MinStack() {
            }

            public void push(int val) {
                if (stack.isEmpty()) {
                    stack.push((long) val);
                    min = val;
                } else if (val < min) {
                    long encoded = 2L * val - min;
                    stack.push(encoded);
                    min = val;
                } else {
                    stack.push((long) val);
                }
            }

            public void pop() {
                long top = stack.pop();

                if (top < min) {
                    min = 2L * min - top;
                }
            }

            public int top() {
                long top = stack.peek();

                if (top < min) {
                    return (int) min;
                }

                return (int) top;
            }

            public int getMin() {
                return (int) min;
            }

     */
}
