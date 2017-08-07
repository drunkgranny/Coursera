package algorithm_toolbox.week2;

import java.util.*;

public class FibonacciLastDigit {

    /** Naive algorithm */
//    private static int getFibonacciLastDigitNaive(int n) {
//        if (n <= 1)
//            return n;
//
//        int previous = 0;
//        int current  = 1;
//
//        for (int i = 0; i < n - 1; ++i) {
//            int tmp_previous = previous;
//            previous = current;
//            current = tmp_previous + current;
//        }
//
//        return current % 10;
//    }

    /** Efficient algorithm */
    private static long getFibonacciLastDigitEfficient(int n) {
        if (n <= 1) {
            return n;
        } else {
            long[] fibonacci = new long[n + 1];
            fibonacci[0] = 0;
            fibonacci[1] = 1;
            for (int i = 2; i <= n; i++) {
                fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 10;
            }
            return fibonacci[n];
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //Replace Naive Algorithm for Efficient
//        int c = getFibonacciLastDigitNaive(n);
        long c = getFibonacciLastDigitEfficient(n);
        System.out.println(c);
    }
}

