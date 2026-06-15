package CodeChef.Arrays;

/*
https://www.codechef.com/practice/course/arrays/ARRAYSPRO/problems/KITCHENCOST
 */
public class CostOfGroceries {
    public int compute(int n, int x, int[] a, int[] b) {
        // write your code here
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= x)
                totalCost = totalCost + b[i];
        }

        return totalCost;
    }
}
