import java.util.Scanner;

public class Problem327A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int current = 0;
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            if (a[i] == 1) current++;
        }

        int[] scanned_a = new int[n];
        scanned_a[0] = a[0] == 0 ? 1 : -1;
        for (int i = 1; i < n; i++)
            scanned_a[i] = scanned_a[i-1] + (a[i] == 0 ? 1 : -1);

        int max = -1;
        // i == 0
        for (int j = 0; j < n; j++) {
            int diff = scanned_a[j];
            if (diff > max) max = diff;
        }
        // other i
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int diff = scanned_a[j] - scanned_a[i-1];
                if (diff > max) max = diff;
            }
        }

        System.out.println(current + max);
    }
}
