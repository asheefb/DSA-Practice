package LeetCode.Arrays.PrefixSum;

/*
https://leetcode.com/problems/find-pivot-index/
 */

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + nums[i];

        for (int i = 0; i < n; i++) {
            int leftSum = i == 0 ? 0 : sumRange(prefix, 0, i - 1);
            int rightSum = i == n - 1 ? 0 : sumRange(prefix, i + 1, n - 1);

            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }

    public int sumRange(int[] prefix, int left, int right) {
        if (left == 0)
            return prefix[right];
        return prefix[right] - prefix[left - 1];
    }
}
