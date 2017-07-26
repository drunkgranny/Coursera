package week2;

import java.util.Scanner;

public class GCD {

    /** Naive week2.GCD algorithm */
//  private static int gcd_naive(int a, int b) {
//    int current_gcd = 1;
//    for(int d = 2; d <= a && d <= b; ++d) {
//      if (a % d == 0 && b % d == 0) {
//        if (d > current_gcd) {
//          current_gcd = d;
//        }
//      }
//    }
//
//    return current_gcd;
//  }

    /**
     * Euclidean week2.GCD algorithm
     */
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

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        //Replace Naive week2.GCD algorithm for Euclidean
//      System.out.println(gcd_naive(a, b));
        System.out.println(euclideanGCD(a, b));
    }
}
