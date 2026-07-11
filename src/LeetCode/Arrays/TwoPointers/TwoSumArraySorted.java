package LeetCode.Arrays.TwoPointers;

import java.util.Arrays;

/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */

public class TwoSumArraySorted {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            int sum = numbers[start] + numbers[end];
            if (sum == target)
                return new int[]{start + 1, end + 1};
            else if (sum < target)
                start++;
            else
                end--;
        }
        return new int[]{-1, -1};
    }
}
