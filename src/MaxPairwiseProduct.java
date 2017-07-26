import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {

    private static long getMaxPairwiseProduct(long[] numbers) {
        int n = numbers.length;
        int maxIndex1 = -1;
        for (int i = 0; i < n; ++i) {
            if ((maxIndex1 == -1) || numbers[i] > numbers[maxIndex1]) {
                maxIndex1 = i;
            }
        }

        int maxIndex2 = -1;
        for (int j = 0; j < n; j++) {
            if ((j != maxIndex1) && ((maxIndex2 == -1) || (numbers[j] > numbers[maxIndex2]))) {
                maxIndex2 = j;
            }
        }
        return (numbers[maxIndex1] * numbers[maxIndex2]);
    }

    public static void main(String[] args) {

        while (true) {
            Random random = new Random();
            int n = random.nextInt(10) + 2;
            System.out.println(n);
            long[] numbers = new long[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = random.nextInt(100000);
            }

            for (int i = 0; i < n; i++) {
                System.out.println(numbers[i]);
            }
            System.out.println();
            long result = getMaxPairwiseProduct(numbers);
            System.out.println(result);
        }

//        FastScanner scanner = new FastScanner(System.in);
//        int n = scanner.nextInt();
//        long[] numbers = new long[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = scanner.nextInt();
//        }
//        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {

        BufferedReader br;

        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}