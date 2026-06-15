package Arrays;

/*
https://www.codechef.com/practice/course/arrays/ARRAYS/problems/SQUIDRULE
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SquidGame {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            StringTokenizer st = new StringTokenizer(reader.readLine());

            long totalSum = 0;
            int minVal = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int val = Integer.parseInt(st.nextToken());
                totalSum += val;
                if (val < minVal) {
                    minVal = val;
                }
            }
            // The maximum prize is total sum excluding the smallest element
            System.out.println(totalSum - minVal);
        }
    }
}
