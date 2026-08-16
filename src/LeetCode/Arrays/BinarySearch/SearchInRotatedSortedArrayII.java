package LeetCode.Arrays.BinarySearch;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 */

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }


            if (nums[start] <= nums[mid]) { //left half sorted
                if (nums[start] <= target && nums[mid] > target)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }

        }
        return false;
    }
}
