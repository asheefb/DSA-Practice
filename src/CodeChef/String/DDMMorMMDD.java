package CodeChef.String;

import java.util.Scanner;

/*
https://www.codechef.com/practice/course/strings/STRINGS/problems/DDMMORMMDD
 */
public class DDMMorMMDD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String s = scanner.next();

            // Your code goes here
            int form1 = Integer.parseInt(s.substring(0, 2));
            int form2 = Integer.parseInt(s.substring(3, 5));

            if (form1 <= 12 && form2 <= 12)
                System.out.println("BOTH");
            else if (form1 > 12 && form2 <= 12)
                System.out.println("MM/DD/YYYY");
            else if (form1 <= 12)
                System.out.println("DD/MM/YYYY");
        }
    }
}
