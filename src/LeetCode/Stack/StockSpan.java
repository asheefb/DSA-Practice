package LeetCode.Stack;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(stockSpan(new int[]{100, 80, 60, 70, 60, 75, 85})));
    }

    public static int[] stockSpan(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        Stack<Map<Integer, Integer>> integers = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()])
                stack.pop();

            if (stack.isEmpty())
                res[i] = i + 1;
            else
                res[i] = i - stack.peek();

            stack.push(i);
        }

        return res;
    }
}
