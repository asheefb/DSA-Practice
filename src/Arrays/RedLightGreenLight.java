package Arrays;

import java.util.*;
import java.lang.*;

/*
    https://www.codechef.com/practice/course/arrays/ARRAYS/problems/DOLL?tab=statement
 */
class RedLightGreenLight {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int[] arr = new int[2];

            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            int[] players = new int[arr[0]];

            int count = 0;

            for (int i = 0; i < players.length; i++) {
                players[i] = sc.nextInt();
            }

            for (int playerHeight : players) {
                if (playerHeight > arr[1])
                    count++;
            }

            System.out.println(count);
        }

    }
}
