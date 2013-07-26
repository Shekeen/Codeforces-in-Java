import java.io.IOException;
import java.util.Scanner;

public class Problem332B {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = s.nextInt();

        long[] absurd = new long[n-k+1];
        absurd[0] = 0;
        for (int i = 0; i < k; i++)
            absurd[0] += x[i];
        for (int i = 1; i < n-k+1; i++)
            absurd[i] = absurd[i-1] - x[i-1] + x[i+k-1];

        int a = n - 2 * k;
        int b = n - k;
        int second_interval = n - k;

        for (int i = a - 1; i >= 0; i--) {
            if (absurd[i + k] >= absurd[second_interval])
                second_interval = i + k;
            if (absurd[i] + absurd[second_interval] >= absurd[a] + absurd[b]) {
                a = i;
                b = second_interval;
            }
        }

        System.out.printf("%d %d\n", a + 1, b + 1);
    }
}
