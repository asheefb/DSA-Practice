package LeetCode.Arrays.BinarySearch;

/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */

public class FindMin {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid;
        }
        return nums[end];
    }
}
