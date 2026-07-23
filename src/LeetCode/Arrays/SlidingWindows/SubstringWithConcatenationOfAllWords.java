package LeetCode.Arrays.SlidingWindows;

/*
https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/?envType=problem-list-v2&envId=sliding-window
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        findSubstring2("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"}).forEach(System.out::println);
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        String word = String.join("", words);

        List<Integer> res = new ArrayList<>();

        int windowSize = word.length();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (Character ch : word.toCharArray())
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);

        for (Character ch : s.substring(0, windowSize).toCharArray())
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

        if (map1.equals(map2))
            res.add(0);

        for (int i = windowSize; i < s.length(); i++) {
            char removal = s.charAt(i - windowSize);
            map2.put(removal, map2.getOrDefault(removal, 0) - 1);

            if (map2.get(removal) == 0)
                map2.remove(removal);

            char addable = s.charAt(i);
            map2.put(addable, map2.getOrDefault(addable, 0) + 1);

            if (map1.equals(map2))
                res.add(i - windowSize);
        }


        return res;

    }

    public static List<Integer> findSubstring2(String s, String[] words) {
        String joined = String.join("", words);

        List<Integer> res = new ArrayList<>();

        int windowSize = joined.length(), mapSize = words[0].length();

        if (windowSize > s.length())
            return res;

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String word : words)
            map1.put(word, map1.getOrDefault(word, 0) + 1);

        for (int i = 0; i < windowSize; i += mapSize) {
            String substring = s.substring(i, i + mapSize);
            map2.put(substring, map2.getOrDefault(substring, 0) + 1);
        }

        if (map1.equals(map2))
            res.add(0);

        for (int i = windowSize; i < s.length(); i += mapSize) {
            int start = i - windowSize;
            String removal = s.substring(start, start + mapSize);
            map2.put(removal, map2.getOrDefault(removal, 0) - 1);

            if (map2.get(removal) == 0)
                map2.remove(removal);

//            putInMap(map2, s.substring(i, windowSize+i), mapSize);
//            int st = i;
            String addable = s.substring(i + 1, i + mapSize);
            map2.put(addable, map2.getOrDefault(addable, 0) + 1);

            if (map1.equals(map2))
                res.add(i - windowSize + mapSize);
        }

        return res;
    }

    private static void putInMap(Map<String, Integer> map2, String substring, Integer mapSize) {
        for (int i = 0; i < substring.length(); i += mapSize) {
            String sub = substring.substring(i, i + mapSize);
            map2.put(sub, map2.getOrDefault(sub, 0) + 1);
        }
    }
}
