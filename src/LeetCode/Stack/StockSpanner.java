package LeetCode.Stack;

import java.util.Stack;

/*
https://leetcode.com/problems/online-stock-span/
 */

public class StockSpanner {

    static class Pair {
        int price;
        int span;

        Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    int currentIndex;
    Stack<Pair> stack = new Stack<>();

    StockSpanner() {

    }

    public int next(int price) {

        while (!stack.isEmpty() && price >= stack.peek().price)
            stack.pop();

        int res = 0;
        if (stack.isEmpty())
            res = currentIndex + 1;
        else
            res = currentIndex - stack.peek().span;

        stack.push(new Pair(price, currentIndex));
        currentIndex++;

        return res;

//        int span = 1;
//
//        while (!stack.isEmpty() && price >= stack.peek().price) {
//            span += stack.peek().span;
//            stack.pop();
//        }
//
//        stack.push(new Pair(price, span));
//        return span;
    }
}

