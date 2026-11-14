package LeetCode.Stack;

import java.util.*;

/*
https://leetcode.com/problems/asteroid-collision/description/
 */

public class AsteroidCollision {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> stack = new Stack<>();
        for (int current : asteroids) {
            boolean isAlive = true;
            while (!stack.isEmpty() && stack.peek() > 0 && current < 0 && isAlive) {
                if (Math.abs(current) == stack.peek()) {
                    stack.pop();
                    isAlive = false;
                } else if (Math.abs(current) > stack.peek())
                    stack.pop();
                else
                    isAlive = false;

            }
            if (isAlive)
                stack.push(current);

        }
        int[] res = new int[stack.size()];

        for (int i = res.length - 1; i >= 0; i--)
            res[i] = stack.pop();

        return res;
    }
}
