package LeetCode.Stack;

import java.util.Stack;

/*
https://leetcode.com/problems/132-pattern/
 */

public class One32Pattern {
    public boolean find132pattern(int[] nums) {

        int n = nums.length;

        Stack<Integer> stack = new Stack<>();

        int second = Integer.MIN_VALUE;
        boolean foundSecond = false;

        for (int i = n - 1; i >= 0; i--) {

            if (foundSecond && nums[i] < second) {
                return true;
            }

            // Find a larger first-side value and update second
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                second = Math.max(second, stack.pop());
                foundSecond = true;
            }

            stack.push(nums[i]);
        }

        return false;
    }
}
