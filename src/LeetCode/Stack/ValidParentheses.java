package LeetCode.Stack;

import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                else if (c == ')' && stack.peek() == '(' ||
                        c == ']' && stack.peek() == '[' ||
                        c == '}' && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
