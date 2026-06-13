package Arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumOfDistinctLargestAndSecondLarget {
    public static int solve(int[] arr) {
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;

        for (int a : arr) {
            if (a > firstMax) {
                secondMax = firstMax;
                firstMax = a;
            } else if (a > secondMax && a != firstMax) {
                secondMax = a;
            }
        }
        int[] array = Arrays.stream(arr).distinct().sorted().toArray();
//        return firstMax + secondMax;
        return array[array.length - 1] + array[array.length - 2];
    }
}
