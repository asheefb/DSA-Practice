package LeetCode.Arrays.BinarySearch;
/*
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 */

import java.util.Arrays;

public class Capacity {
    public int shipWithinDays(int[] weights, int days) {
        int start = Arrays.stream(weights).max().getAsInt();
        int end = Arrays.stream(weights).sum();

        int minCap = 0;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int possibleDays = 1, sum = 0;

            for (int weight : weights) {
                sum += weight;

                if (sum > mid) {
                    possibleDays++;
                    sum = weight;
                }
            }

            if (possibleDays <= days)
                end = mid;
            else
                start = mid + 1;

        }
        return end;
    }
}
