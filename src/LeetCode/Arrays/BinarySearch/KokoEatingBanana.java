package LeetCode.Arrays.BinarySearch;

/*
https://leetcode.com/problems/koko-eating-bananas/description/
 */

import java.util.Arrays;

public class KokoEatingBanana {

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11},8));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = Arrays.stream(piles).max().getAsInt(), ans = 0;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int totalHours = 0;

            for (int pile : piles)
                totalHours += (int) Math.ceil((double) pile /mid);

            if (totalHours <= h)
                end = mid;
            else
                start = mid + 1;
        }
        return end;
    }
}
