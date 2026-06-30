package String.TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class ValidPallindrome2 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("cbbcc"));
    }

    public static boolean validPalindrome(String s) {
        boolean isDeleted = false;
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                isDeleted = true;
                if (Math.abs(s.indexOf(start)) > Math.abs(s.indexOf(end) - s.length() - 1))
                    end--;
                else
                    start++;

            }

            if (isDeleted == true && s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }

    public static boolean validPalindrome2(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (int freq : map.values()) {
            if (freq == 1)
                count++;
        }

        return s.length() % 2 == 0 ? count <= 1 : count <= 2;
    }
}
