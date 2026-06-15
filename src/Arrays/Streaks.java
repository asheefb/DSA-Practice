package Arrays;

import java.util.Scanner;
/*
https://www.codechef.com/practice/course/arrays/ARRAYS/problems/CS2023_STK?tab=statement
 */
public class Streaks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
            for (int i = 0; i < n; i++) b[i] = scanner.nextInt();

            System.out.println(calculateWinner(n, a, b));
        }
        scanner.close();
    }

    public static String calculateWinner(int n, int[] om, int[] addy) {
        int omMax = getMaxStreak(om);
        int addyMax = getMaxStreak(addy);

        if (omMax > addyMax) return "OM";
        if (addyMax > omMax) return "ADDY";
        return "DRAW";
    }

    private static int getMaxStreak(int[] arr) {
        int max = 0, current = 0;
        for (int val : arr) {
            if (val > 0) {
                current++;
                if (current > max) max = current;
            } else {
                current = 0;
            }
        }
        return max;
    }
}
