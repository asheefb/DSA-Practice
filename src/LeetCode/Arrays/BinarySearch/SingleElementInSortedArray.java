package LeetCode.Arrays.BinarySearch;

public class SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid % 2 == 1)
                mid--;

            if (mid % 2 == 0) { // evens
                if (nums[mid] == nums[mid + 1])
                    start = mid + 2;
                else
                    end = mid;
            }
        }
        return nums[end];
    }
}
