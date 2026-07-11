package LeetCode.String;

import java.util.Arrays;

public class sumAndMultiply {

    public static void main(String[] args) {
        int[] ints = sumAndMultiply2("10203004", new int[][]{{0, 7}, {1, 3}, {4, 6}});

        System.out.println(Arrays.toString(ints));
    }

    public static int[] sumAndMultiply2(String s, int[][] queries) {
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            String sub = s.substring(left, right + 1);
            int[] ans = getSum(sub);
            res[i] = ans[0] * ans[1];
        }

        return res;
    }

    private static int[] getSum(String s) {
        int num = 0, sum = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch) && ch != '0') {
                num = num * 10 + (ch - '0');
                sum += (ch - '0');
            }
        }
        return new int[]{num, sum};
    }

    private static String getPrefix(String s, int left, int right) {
        return s.substring(left, right + 1);
    }


    public int[] sumAndMultiply(String s, int[][] queries) {
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int[] sum = getSum(queries[i], s);

            res[i] = sum[0] * sum[1];
        }

        return res;
    }

    public int[] getSum(int[] a, String s) {
        int num = 0, sum = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch) && ch != '0') {
                num = num * 10 + (ch - '0');
                sum += (ch - '0');
            }
        }
        return new int[]{num, sum};
    }
}
