package CodeChef.Arrays;
/*
https://www.codechef.com/practice/course/arrays/ARRAYS/problems/MAXCONSECU
 */
public class ConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0; // Stores the overall maximum
        int currentCount = 0; // Stores the current streak of 1s

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                // Update maxCount whenever current streak grows
                maxCount = Math.max(maxCount, currentCount);
            } else {
                // Reset streak when a 0 is encountered
                currentCount = 0;
            }
        }
        return maxCount;
    }
}
