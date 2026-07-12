package LeetCode.Arrays.SlidingWindows;

/*
https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class MinimumSizeOfSubArraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen2(4, new int[]{1, 4, 4}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i], length = 1;
            for (int j = i + 1; j <= nums.length; j++) {

                if (sum >= target) {
                    minLength = Math.min(minLength, length);
                    break;
                }
                sum += nums[j];
                length++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    //Optimised
    public static int minSubArrayLen2(int target, int[] nums) {
        int start = 0, end = 0, minLength = Integer.MAX_VALUE;
        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
            prefix[i] = prefix[i - 1] + nums[i];

        while (end < nums.length) {
            int sum = getPrefix(prefix, start, end);

            if (sum >= target) {
                int length = (end - start) + 1;

                minLength = Math.min(length, minLength);
                start++;
            } else
                end++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int getPrefix(int[] prefix, int start, int end) {
        if (start == 0)
            return prefix[end];
        return prefix[end] - prefix[start - 1];
    }
}
