package LeetCode.Arrays;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/contains-duplicate/description/
 */

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int num : nums) {
            if (!s.add(num))
                return true;

            s.add(num);
        }
        return false;
    }
}
