package LeetCode.Arrays.PrefixSum;

import java.util.Scanner;

public class PivotIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int rightSum = sum(prefix, i + 1, n - 1);
            int leftSum = i == 0 ? 0 : sum(prefix, 0, i - 1);

            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }

    public static int sum(int[] prefix, int left, int right) {
        if (left == 0)
            return prefix[right];

        return prefix[right] - prefix[left - 1];
    }
}
