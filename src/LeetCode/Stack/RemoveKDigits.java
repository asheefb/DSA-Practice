package LeetCode.Stack;
/*
https://leetcode.com/problems/remove-k-digits/
 */

import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        StringBuilder res = new StringBuilder("");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k > 0 && !stack.isEmpty()) {
            k--;
            stack.pop();
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        String result = res.reverse().toString().replaceFirst("^0+", "");
        return result.isEmpty() ? "0" : result;
    }
}
