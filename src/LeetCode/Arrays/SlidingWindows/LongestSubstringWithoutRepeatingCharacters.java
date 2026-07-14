package LeetCode.Arrays.SlidingWindows;
/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 1)
            return 1;

        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (!set.add(s.charAt(j))) {
                    break;
                }
                maxLength = Math.max(maxLength, set.size());
            }
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int start = 0, end = 0, maxLength = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {

            if (!set.add(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            end++;

            maxLength = Math.max(maxLength, set.size());

        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
