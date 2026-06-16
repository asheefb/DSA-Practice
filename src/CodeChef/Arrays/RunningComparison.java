package CodeChef.Arrays;

import java.util.Scanner;

/*
https://www.codechef.com/practice/course/arrays/ARRAYSPRO/problems/RUNCOMPARE
*/
public class RunningComparison {
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
            // Your code goes here
            System.out.println(isBothAliceAndBobHappy(n, a, b));
        }
    }

    private static int isBothAliceAndBobHappy(int n, int[] a, int[] b) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] <= b[i] * 2 && b[i] <= a[i] * 2) {
                count++;
            }

        }
        return count;
    }
}
