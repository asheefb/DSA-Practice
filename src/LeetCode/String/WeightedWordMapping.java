package LeetCode.String;

import java.util.Scanner;

public class WeightedWordMapping {
    public static String mapWordWeights(String[] words, int[] weights) {

        StringBuilder res = new StringBuilder();
        for (String word : words) {
            char[] chars = word.toCharArray();
            int sum = 0;
            for (char aChar : chars) {
                sum += weights[aChar - 97];
            }

            char c = (char) ('z' - (sum % 26));
            res.append(c);
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String[] words = new String[size];
        sc.nextLine();
        System.out.println("Enter Words");
        for (int i = 0; i < words.length; i++) {
            words[i] = sc.nextLine();
        }


        int[] weights = new int[26];

        System.out.println("Enter Wirfhts");
        for (int i = 0; i < weights.length; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.println(mapWordWeights(words, weights));
    }
}
