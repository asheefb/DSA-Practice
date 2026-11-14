package LeetCode.Stack;

import java.util.Stack;

/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    public static int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") ||
                    token.equals("/") || token.equals("*")) {
                int popedLenght = 0, res = 0;
                Integer sec = null;
                while (popedLenght != 2) {
                    int first = stack.pop();
                    popedLenght++;

                    if (sec == null)
                        sec = first;
                    else {
                        switch (token) {
                            case "+":
                                res = first + sec;
                                break;
                            case "-":
                                res = first - sec;
                                break;
                            case "/":
                                res = first / sec;
                                break;
                            case "*":
                                res = first * sec;
                                break;
                            default:
                                throw new IllegalArgumentException("Invalid operator: " + token);
                        }
                    }
                }
                stack.push(res);
            } else
                stack.push(Integer.valueOf(token));
        }

        return stack.pop();
    }
}
