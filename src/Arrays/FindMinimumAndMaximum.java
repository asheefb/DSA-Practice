package Arrays;

public class FindMinimumAndMaximum {
    public static int[] minAndMax(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int a : arr) {
            if (a < min)
                min = a;

            if (a > max)
                max = a;
        }
        return new int[]{min, max};
    }
}
