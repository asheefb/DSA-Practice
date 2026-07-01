package LeetCode.Arrays.TwoPointers;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        moveZeroes2(new int[]{1, 0, 1});
    }

    //    6%
    public static void moveZeroes(int[] nums) {
        int start = 0, end = 1;

        while (end < nums.length) {
            if (nums[start] == 0 && nums[end] != 0) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                start++;
                end++;
            } else if (nums[start] == 0 && nums[end] == 0)
                end++;
            else {
                start++;
                end++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes2(int[] nums) {
        int fast = 0, slow = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0 && nums[slow] != 0) {
                fast++;
                slow++;
                continue;
            }

            if (nums[fast] == 0)
                fast++;
            else {
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
                fast++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
