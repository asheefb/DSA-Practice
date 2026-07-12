package LeetCode.Arrays.SlidingWindows;

public class MaximumSizeOfSubArraySum {
    public static int maxSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, maxLength = Integer.MIN_VALUE;

        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            prefix[i] = prefix[i - 1] + nums[i];

        while (end < nums.length) {

            int sum = getPrefix(prefix, start, end);

            if (sum >= target) {
                int length = (end - start) + 1;
                maxLength = Math.max(maxLength, length);
                start++;
            } else
                end++;
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    private static int getPrefix(int[] prefix, int start, int end) {
        if (start == 0)
            return prefix[end];
        return prefix[end] - prefix[start - 1];
    }
}
