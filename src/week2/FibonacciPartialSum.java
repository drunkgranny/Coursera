package week2;

import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < from - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        long sum = current;

        for (long i = 0; i < to - from; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static long getPisanoPariod(long m) {
        long a = 0;
        long b = 1;
        long c = a + b;

        for (int i = 0; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1) {
                return i + 1;
            }
        }
        return c;
    }

    private static long getFibonacciHugeEfficient(long n, long m) {
        if (n <= 1)
            return n;

        long remainder = n % getPisanoPariod(m);

        long previous = 0;
        long current  = 1;

        long res = remainder;

        for (long i = 1; i < remainder; i++) {
            res = (previous + current) % m;
            previous = current;
            current = res;
        }

        return res % m;
    }

    /** Efficient A;gorithm */
    private static long getFibonacciPartialSumEfficient(long from, long to) {
        return (getFibonacciHugeEfficient(to + 2, 10) + 10 - getFibonacciHugeEfficient(from + 1, 10)) % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumEfficient(from, to));
    }
}

