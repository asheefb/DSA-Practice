package LeetCode.Stack;

import java.util.Stack;

/*
https://leetcode.com/problems/largest-rectangle-in-histogram/
 */

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 4, 2, 1}));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {

                Integer poppedIndex = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, heights[poppedIndex] * width);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int poppedIndex = stack.pop();
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, heights[poppedIndex] * width);
        }
        return maxArea;
    }
}
