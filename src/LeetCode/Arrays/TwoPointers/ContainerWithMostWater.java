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
}
