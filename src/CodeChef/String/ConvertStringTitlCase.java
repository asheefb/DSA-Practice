package CodeChef.String;

import java.util.Scanner;

public class ConvertStringTitlCase {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        sc.nextLine();

        while (t-- > 0) {

            String s = sc.nextLine();
            String[] words = s.split(" ");

            StringBuilder res = new StringBuilder();

            for (String word : words) {
                boolean isEligible = false;
                char[] charArray = word.toCharArray();
                for (char ch : charArray) {
                    if (Character.isLowerCase(ch)) {
                        isEligible = true;
                        break;
                    }
                }

                if (isEligible) {
                    word = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
                }
                res.append(word).append(" ");
            }

            System.out.println(res);


        }
    }
}