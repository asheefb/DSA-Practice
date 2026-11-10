package LeetCode.Stack;

import java.util.Stack;

/*
https://leetcode.com/problems/maximal-rectangle/description/
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int[] heights = new int[matrix[0].length];
        int maxArea = 0;


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1')
                    heights[col] = heights[col] + 1;
                else if (matrix[row][col] == '0')
                    heights[col] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int max = 0, n = heights.length;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int popedIndex = stack.pop();

                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                max = Math.max(max, heights[popedIndex] * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int popedIndex = stack.pop();

            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            max = Math.max(max, heights[popedIndex] * width);
        }
        return max;
    }
}
