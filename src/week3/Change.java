package week3;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int ten = 10, five = 5, one = 1;
        int coins;

        coins = m / ten;
        m = m % ten;
        coins += m / five;
        m = m % five;
        coins += m / one;
        return coins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

