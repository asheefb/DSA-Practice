package Recurssion;

public class Fibonacci {

    public static void normal(int n) {

        int f1 = 0, f2 = 1;

        for (int i = 2; i <= n; i++) {
            System.out.println(f1 + " ");
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
    }

    public static int fib(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;

        return fib(n - 1) + fib(n - 2);
    }
}
