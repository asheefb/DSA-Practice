package LeetCode.Arrays.BinarySearch;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    //bruce force
    public static int[] searchRange(int[] nums, int target) {
        boolean isFound = false;
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (!isFound && nums[i] == target) {
                res[0] = i;
                isFound = true;
            }

            if (isFound && nums[i] != target)
                res[1] = i - 1;
        }
        return res;
    }
}
