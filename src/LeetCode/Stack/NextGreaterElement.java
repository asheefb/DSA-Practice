package LeetCode.Stack;

import java.util.*;

/*
https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElement {

    //brute force acceptable in leet code
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer,Integer> map = new HashMap<>();



        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            int index = findIndex(x, nums2);

            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > x) {
                    res[i] = nums2[j];
                    break;
                } else
                    res[i] = -1;
            }

        }
        return res;
    }

    private int findIndex(int x, int[] nums2) {

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == x)
                return i;
        }
        return -1;
    }

    //monotonic stack
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
//        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int num : nums2) {

            while (!stack.isEmpty() && num > stack.peek()) {
                int top = stack.peek();
                stack.pop();
                map.put(top, num);
            }
            stack.push(num);
        }

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;
    }
}
