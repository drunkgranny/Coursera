package week2;

import java.util.*;

public class FibonacciHuge {

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeEfficient(n, m));
    }
}

