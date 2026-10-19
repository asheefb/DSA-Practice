package LeetCode.Stack;

/*
https://leetcode.com/problems/daily-temperatures/description/
 */

import java.util.Stack;

public class DailyTemperature {

    //brute force
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int days = 0;

            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] <= temperatures[i])
                    days++;
                else {
                    days++;
                    break;
                }
            }

            if (days > 0 &&
                    temperatures[i + days] <= temperatures[i]) {
                days = 0;
            }
            res[i] = days;
        }

        return res;
    }

    //using monotic stack
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()
                    && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty())
                res[i] = stack.peek() - i;

            stack.push(i);
        }

        return res;
    }
}
