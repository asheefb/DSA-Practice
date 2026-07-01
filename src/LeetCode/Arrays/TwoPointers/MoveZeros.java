package LeetCode.Arrays.TwoPointers;

import java.util.Arrays;

public class MoveZeros {

        public void moveZeroes(int[] nums) {
            int start = 0, end = 1;

            while (end < nums.length) {
                if (nums[start] == 0) {
                    int temp = nums[end];
                    nums[end] = nums[start];
                    nums[start] = temp;
                }
                start++;
                end++;
            }

            System.out.println(Arrays.toString(nums));
        }
}
