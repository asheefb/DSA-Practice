package LeetCode.Stack;

import java.util.Arrays;

/*
https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElement {

    //brute force acceptable in leet code
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

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
}
