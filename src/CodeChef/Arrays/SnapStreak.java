package CodeChef.Arrays;

/*
https://www.codechef.com/practice/course/arrays/ARRAYSPRO/problems/SNAPCHAT
 */

import java.util.Scanner;

public class SnapStreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(countStreak(n, a, b));
        }
        // Your code goes here
    }

    private static int countStreak(int n, int[] a, int[] b) {
        int streak = 0, maxStreak = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] != 0 && b[i] != 0) {
                streak++;
                maxStreak = Math.max(streak, maxStreak);
            } else
                streak = 0;
        }

        return maxStreak;
    }
}
