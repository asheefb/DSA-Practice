package LeetCode.Stack;

import java.util.Arrays;
import java.util.Stack;

/*
https://leetcode.com/problems/next-greater-element-ii/description/
 */
public class NextGreaterElement2 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
    }

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            while (!stack.isEmpty() && nums[idx] >= nums[stack.peek()])
                stack.pop();

            if (!stack.isEmpty() && res[idx] == -1) {
                res[idx] = nums[stack.peek()];
            }

            stack.push(idx);
        }
        return res;
    }

}
