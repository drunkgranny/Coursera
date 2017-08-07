package algorithm_toolbox.week2;

import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    /** Efficient algorithm */
    private static long getFibonacciSumEfficient(long n) {
        if (n <= 1) {
            return n;
        } else {
            n = (n + 2) % 60;
            long[] fibonacci = new long[(int)(n + 1)];
            fibonacci[0] = 0;
            fibonacci[1] = 1;
            for (int i = 2; i <= n; i++) {
                fibonacci[i] += (fibonacci[i - 1] % 10 + fibonacci[i - 2] % 10) % 10;
            }
            if (fibonacci[(int)n] == 0) {
                return 9;
            }
            return fibonacci[(int)n] % 10 - 1;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(getFibonacciSumEfficient(n));
    }
}

