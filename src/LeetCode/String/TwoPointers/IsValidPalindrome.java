package LeetCode.String.TwoPointers;

public class IsValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome2("race a car"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }

        int start = 0, end = sb.length() - 1;

        while (start < end) {
            if (sb.charAt(start) != sb.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        int n = s.length(), start = 0, end = n - 1;

        while (start < end) {
            char ch1 = s.charAt(start), ch2 = s.charAt(end);
            if (!Character.isLetterOrDigit(ch1))
                start++;

            else if (!Character.isLetterOrDigit(ch2))
                end--;

            else {
                if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2))
                    return false;

                start++;
                end--;
            }
        }
        return true;
    }
}
