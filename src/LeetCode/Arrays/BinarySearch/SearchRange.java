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

    //optimised using binary
    public int[] searchRange2(int[] nums, int target) {
        int first = binary(nums, target, true);
        int last = binary(nums, target, false);

        return new int[] { first, last };
    }

    private int binary(int[] nums, int target, boolean isFirst) {
        int ans = -1;
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target)
                start = mid + 1;
            else if (nums[mid] > target)
                end = mid - 1;
            else {
                ans = mid;
                if (isFirst)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return ans;
    }
}
