package LeetCode.Arrays.TwoPointers;

/*
https://leetcode.com/problems/container-with-most-water
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int n = height.length, maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                int h = Math.min(height[i], height[j]), w = j - i;

                int area = h * w;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    //optimised 2 pointer
    public static int maxArea2(int[] height) {
        int start = 0, end = height.length-1, maxArea = 0;

        while (start < end) {
            int width = end - start, h = Math.min(height[start], height[end]);

            int area = width * h;

            maxArea = Math.max(maxArea, area);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;

    }
}
