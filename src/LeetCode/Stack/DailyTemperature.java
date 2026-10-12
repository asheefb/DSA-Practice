package LeetCode.Stack;

/*
https://leetcode.com/problems/daily-temperatures/description/
 */

public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int days = 0;

            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] <= temperatures[i])
                    days++;
                else {
                    days++;
                    break;
                }
            }

            if (days > 0 &&
                    temperatures[i + days] <= temperatures[i]) {
                days = 0;
            }
            res[i] = days;
        }

        return res;
    }
}
