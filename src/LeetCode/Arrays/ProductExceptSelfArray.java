package LeetCode.Arrays;

/*
https://leetcode.com/problems/product-of-array-except-self/
 */

public class ProductExceptSelfArray {
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j)
                    prod *= nums[j];
            }
            res[i] = prod;
        }
        return res;
    }

    //optimised
    public int[] productExceptSelf2(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
