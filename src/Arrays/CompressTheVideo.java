package Arrays;

import java.util.Scanner;

public class CompressTheVideo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            if (n == 0) {
                System.out.println(0);
                continue;
            }

            int count = 1; // Always keep the first frame
            for (int i = 1; i < n; i++) {
                // If the current frame is different from the previous, it's a new segment
                if (arr[i] != arr[i - 1]) {
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
