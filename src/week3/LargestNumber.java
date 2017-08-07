package week3;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        Arrays.sort(a, (o1, o2) -> {
            int i1 = Integer.parseInt(o1);
            int i2 = Integer.parseInt(o2);
            int i3 = Integer.parseInt(i1 + "" + i2);
            int i4 = Integer.parseInt(i2 + "" + i1);
            return -Integer.compare(i3, i4);
        });
        return String.join("", a);
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
        largestNumber(a);
    }
}

