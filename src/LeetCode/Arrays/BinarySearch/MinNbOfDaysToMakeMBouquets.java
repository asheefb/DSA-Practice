package LeetCode.Arrays.BinarySearch;

/*
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 */

public class MinNbOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long) m * k)
            return -1;

        int start = bloomDay[0], end = bloomDay[0];

        for (int day : bloomDay) {
            start = Math.min(start, day);
            end = Math.max(end, day);
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            int count = 0, consecutive = 0;

            for (int day : bloomDay) {

                if (day <= mid)
                    consecutive++;
                else
                    consecutive = 0;

                if (consecutive == k) {
                    count++;
                    consecutive = 0;
                }
            }

            if (count < m)
                start = mid + 1;
            else
                end = mid;

        }

        return end;
    }
}
