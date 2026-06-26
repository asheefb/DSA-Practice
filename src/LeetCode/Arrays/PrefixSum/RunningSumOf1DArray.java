package LeetCode.Arrays.PrefixSum;

/*
https://leetcode.com/problems/running-sum-of-1d-array/description/
 */

public class RunningSumOf1DArray {

    //brute force
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            res[i] = sum;
        }
        return res;
    }


    //optimised
    public int[] runningSum2(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        return prefix;
    }
}
