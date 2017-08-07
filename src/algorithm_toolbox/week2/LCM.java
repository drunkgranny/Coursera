package algorithm_toolbox.week2;

import java.util.Scanner;

public class LCM {

    /** Naive algorithm */
//    private static long lcm_naive(int a, int b) {
//        for (long l = 1; l <= (long) a * b; ++l)
//            if (l % a == 0 && l % b == 0)
//                return l;
//
//        return (long) a * b;
//    }

    private static long euclideanGCD(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return euclideanGCD(a, b);
    }

    /** Efficient algorithm */
    private static long lcm_efficient(long a, long b) {
        return (a * b) / euclideanGCD(a, b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        // Replace Naive algorithm for Efficient.
//        System.out.println(lcm_naive(a, b));
        System.out.println(lcm_efficient(a, b));
    }
}
