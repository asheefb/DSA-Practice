package CodeChef.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LargestOddSubString {
    public static String findLargestOddSubstring(String num) {
        // Iterate from the last character to the first
        for (int i = num.length() - 1; i >= 0; i--) {
            // Convert char to integer digit and check if it's odd
            int digit = num.charAt(i) - '0';
            if (digit % 2 != 0) {
                // The first odd digit found from the right provides the largest substring
                return num.substring(0, i + 1);
            }
        }
        // If no odd digit is found, return "-1"
        return "-1";
    }

    public static void main(String[] args) {
        System.out.println(findLargestOddSubstring("7"));


    }
}
