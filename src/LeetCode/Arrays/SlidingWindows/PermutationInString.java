package LeetCode.Arrays.SlidingWindows;

/*
https://leetcode.com/problems/permutation-in-string/
 */

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion3("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int windowSize = s1.length();

        String s3 = new StringBuilder(s1).reverse().toString();

        int start = 0, end = windowSize;

        while (end <= s2.length()) {
            if (s1.equals(s2.substring(start, end)) || s3.equals(s2.substring(start, end)))
                return true;
            else {
                start++;
                end++;
            }
        }
        return false;

    }

    public static boolean checkInclusion2(String s1, String s2) {
        int windowSize = s1.length(), start = 0, end = windowSize;

        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : s1.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        while (end <= s2.length()) {
            if (isPermutation(map, s2.substring(start, end))) {
                return true;
            }
            start++;
            end++;
        }
        return false;

    }

    private static boolean isPermutation(Map<Character, Integer> map, String substring) {
        Map<Character, Integer> mp2 = new HashMap<>();

        for (Character ch : substring.toCharArray())
            mp2.put(ch, mp2.getOrDefault(ch, 0) + 1);

        for (Character ch : mp2.keySet()) {
            if (!mp2.get(ch).equals(map.get(ch)))
                return false;
        }
        return true;
    }

    public static boolean checkInclusion3(String s1, String s2) {
        int windowSize = s1.length(), start = 0, end = windowSize;

        if (s1.length() > s2.length())
            return false;

        Map<Character, Integer> map1 = new HashMap<>();

        Map<Character, Integer> map2 = new HashMap<>();

        for (Character ch : s1.toCharArray())
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);

        for (Character ch : s2.substring(start, end).toCharArray())
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

        while (end <= s2.length()) {
            if (isPermutation(map1, map2)) {
                return true;
            }
            char startChar = s2.charAt(start);
            int newCount = map2.getOrDefault(startChar, 0) - 1;

            if (newCount == 0) {
                map2.remove(startChar);
            } else {
                map2.put(startChar, newCount);
            }

            start++;
            end++;
            map2.put(s2.charAt(end - 1), map2.getOrDefault(s2.charAt(end - 1), 0) + 1);
        }
        return false;

    }

    private static boolean isPermutation(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        return map1.equals(map2);
    }


    public boolean checkInclusion4(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Build frequency maps
        for (char ch : s1.toCharArray())
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);

        int windowSize = s1.length();

        // First window
        for (int i = 0; i < windowSize; i++) {
            char ch = s2.charAt(i);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
        }

        if (s1Map.equals(windowMap))
            return true;

        // Slide the window
        for (int i = windowSize; i < s2.length(); i++) {

            char outgoing = s2.charAt(i - windowSize);
            windowMap.put(outgoing, windowMap.get(outgoing) - 1);

            if (windowMap.get(outgoing) == 0)
                windowMap.remove(outgoing);

            char incoming = s2.charAt(i);
            windowMap.put(incoming, windowMap.getOrDefault(incoming, 0) + 1);

            if (s1Map.equals(windowMap))
                return true;
        }

        return false;
    }

}
