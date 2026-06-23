package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReverseString {
    public static String reverse(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static int vowels(String s) {
        int count = 0;
        s = s.toLowerCase();

        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i)))
                count++;
        }
        return count;
    }
}
