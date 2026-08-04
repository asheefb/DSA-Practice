package LeetCode.Arrays;

/*
https://leetcode.com/problems/find-missing-elements/description/?envType=daily-question&envId=2026-08-04
 */

import java.util.*;

public class FindMissingElements {

    public static void main(String[] args) {
        findMissingElements(new int[]{5, 1}).forEach(System.out::println);
    }

    public static List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        if (nums.length == 0)
            return res;

        int smallest = nums[0], largest = nums[0];

        for (int num : nums) {
            set.add(num);
            smallest = Math.min(smallest, num);
            largest = Math.max(largest, num);
        }

        for (int i = smallest; i < largest; i++) {
            if (!set.contains(i))
                res.add(i);
        }

        return res;
    }
}
