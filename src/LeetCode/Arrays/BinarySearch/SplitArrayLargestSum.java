package LeetCode.Arrays.BinarySearch;

/*
https://leetcode.com/problems/split-array-largest-sum/description/
 */

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public static int splitArray(int[] nums, int k) {
        int start = nums[0], end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        while (start < end) {
            int mid = start + (end - start) / 2, count = 1, sum = 0;

            for (int num : nums) {
                sum += num;
                if (sum > mid) {
                    count++;
                    sum = num;
                }
            }

            if (count <= k)
                end = mid;
            else
                start = mid + 1;

        }
        return end;
    }
}
