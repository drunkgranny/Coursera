package week2;

import java.util.Scanner;

public class Fibonacci {

    /** Naive Algorithm */
//    private static long calc_fib(int n) {
//        if (n <= 1)
//            return n;
//
//        return calc_fib(n - 1) + calc_fib(n - 2);
//    }

    /** Efficient Algorithm */
    private static long newCalcFib(int n) {
        if (n <= 1) {
            return n;
        } else {
            long[] fibonacci = new long[n + 1];
            fibonacci[0] = 0;
            fibonacci[1] = 1;
            for (int i = 2; i <= n; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }
            return fibonacci[n];
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // Replace Naive Algorithm on Efficient.
//        System.out.println(calc_fib(n));
        System.out.println(newCalcFib(n));
    }
}
