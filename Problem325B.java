import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Problem325B {
    static int findM(long n, int d) {
        // solve \frac{m(m-1)}{2} + m*(2^d - 1) = n
        // with binary search

        final long c = (1L<<d) - 1;
        long minM = 1L;
        long maxM = 10000000000L;
        long m = (minM + maxM) >> 1;
        BigInteger bigN = BigInteger.valueOf(n);

        while (maxM >= minM) {
            BigInteger lhs = BigInteger.valueOf(m * (m-1) / 2);
            BigInteger bigM = BigInteger.valueOf(m);
            bigM = bigM.multiply(BigInteger.valueOf(c));
            lhs = lhs.add(bigM);
            int compRes = lhs.compareTo(bigN);
            if (compRes < 0) {
                minM = m + 1;
            } else if (compRes > 0) {
                maxM = m - 1;
            } else {
                return (m % 2 == 0) ? 0 : (int)m;
            }
            m = (minM + maxM) >> 1;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        boolean found = false;
        for (int d = 0; d < 63; d++) {
            int m = findM(n, d);
            if (m > 0) {
                found = true;
                System.out.println((long)m << d);
            }
        }
        if (!found) System.out.println(-1);
    }
}

// 999999998765257141
// 2828427122
