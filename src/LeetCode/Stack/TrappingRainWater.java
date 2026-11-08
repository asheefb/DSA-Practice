package LeetCode.Stack;

import java.util.Stack;

/*
https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int res = 0, n = height.length;
        int[] leftMax = new int[n], rightMax = new int[n];
        int lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            lmax = Math.max(height[i], lmax);
            leftMax[i] = lmax;
        }

        for (int i = n - 1; i >= 0; i--) {
            rmax = Math.max(height[i], rmax);
            rightMax[i] = rmax;
        }

        for (int i = 0; i < n; i++)
            res += Math.min(leftMax[i], rightMax[i]) - height[i];

        return res;
    }

    //using monotonic stack
    public int trap2(int[] height) {
        int totalWater = 0, n = height.length;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int popedIndex = stack.pop();

                if (!stack.isEmpty()) {
                    int h = Math.min(height[i], height[stack.peek()]) - height[popedIndex];

                    int width = i - stack.peek() - 1;

                    int water = h * width;
                    totalWater += water;
                }
            }

            stack.push(i);
        }
        return totalWater;

    }
}
