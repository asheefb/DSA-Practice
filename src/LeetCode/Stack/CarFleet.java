package LeetCode.Stack;

import java.util.Arrays;

/*
https://leetcode.com/problems/car-fleet/description/
 */

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;

        Integer[] indices = new Integer[position.length];

        for (int i = 0; i < position.length; i++)
            indices[i] = i;

        Arrays.sort(indices, (a, b) -> Integer.compare(position[b], position[a]));

        double prevTime = 0;
        for (int ele : indices) {
            double curTime = (double) (target - position[ele]) / speed[ele];

            if (curTime > prevTime) {
                res++;
                prevTime = curTime;
            }
        }
        return res;
    }
}
