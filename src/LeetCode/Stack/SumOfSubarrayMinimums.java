package LeetCode.Stack;

import java.util.Arrays;
import java.util.Stack;

/*
https://leetcode.com/problems/sum-of-subarray-minimums/
 */

public class SumOfSubarrayMinimums {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        long MOD = 1_000_000_007;

        int[] pse = new int[n], nse = new int[n];

        Arrays.fill(pse, -1);
        Arrays.fill(nse, n);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();

            if (!stack.isEmpty()) {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();

            if (!stack.isEmpty())
                nse[i] = stack.peek();
            stack.push(i);
        }

        long contri = 0;

        for (int i = 0; i < n; i++) {
            long subArray = (long) (i - pse[i]) * (nse[i] - i);
            long contribution = (arr[i] * subArray) % MOD;

            contri = (contri + contribution) % MOD;
        }

        return (int) contri;
    }
}
