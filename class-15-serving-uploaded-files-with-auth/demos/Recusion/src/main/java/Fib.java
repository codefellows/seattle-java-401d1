package main.java;

import java.util.HashMap;
import java.util.Map;

public class Fib {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(i + ": " + fib(i) + " ");
        }
    }

    // Base case: the function returns a value
    // Recursive case: when the function calls itself
    // returns the nth fibonacci number
    // the first fib is 1
    // the second fib is 1
    // n must be > 0
    public static int fib(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 1);
        return fib(n, memo);
    }

    // use a Map to keep track of inputs that we've already solved.
    private static int fib(int n, Map<Integer, Integer> memo) {
        // return saved values if we've seen them before.
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // otherwise, compute them and save them
        if (n <= 2) {
            return 1;
        }
        int result = fib(n - 1, memo) + fib(n - 2, memo);
        memo.put(n, result);
        return result;
    }
}
