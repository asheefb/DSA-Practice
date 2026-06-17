package CodeChef.String;

import java.util.Scanner;

public class WorldChessChampion {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int x = sc.nextInt();

            int carlsenWon = 0, chefWon = 0;

            sc.nextLine();
            String s = sc.nextLine();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == 'C')
                    carlsenWon += 2;
                if (c == 'N')
                    chefWon += 2;
                if (c == 'D') {
                    carlsenWon++;
                    chefWon++;
                }
            }

            if (carlsenWon > chefWon)
                System.out.println(60 * x);
            else if (chefWon > carlsenWon)
                System.out.println(40 * x);
            else System.out.println(55 * x);
        }
    }
}
